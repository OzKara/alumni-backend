    package accelerate.alumni.alumnibackend.controller;

    import accelerate.alumni.alumnibackend.mappers.UserMapper;
    import accelerate.alumni.alumnibackend.model.User;
    import accelerate.alumni.alumnibackend.model.dtos.user.UserDTO;
    import accelerate.alumni.alumnibackend.model.dtos.user.UserMiniDTO;
    import accelerate.alumni.alumnibackend.model.dtos.user.UserPutDTO;
    import accelerate.alumni.alumnibackend.service.user.UserService;
    import accelerate.alumni.alumnibackend.util.KeycloakInfo;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.media.ArraySchema;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.security.oauth2.jwt.Jwt;
    import org.springframework.web.bind.annotation.*;

    import java.net.URI;
    import java.util.*;
    import java.util.stream.Collectors;

    @PreAuthorize("hasRole('user')")
    @RestController
    @RequestMapping("/api/v1/users")
    public class UserController {
        private final UserService userService;
        private final UserMapper userMapper;
        private final KeycloakInfo keycloakInfo;

        public UserController(UserService userService, UserMapper userMapper, KeycloakInfo keycloakInfo) {
            this.userService = userService;
            this.userMapper = userMapper;
            this.keycloakInfo = keycloakInfo;
        }

        @GetMapping("{id}")
        @Operation(summary = "Get a user by its id", tags = {"User", "Get"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Success",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = UserDTO.class))),
                @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
        })
        public ResponseEntity<UserDTO> findById(@PathVariable String id) {
            return ResponseEntity.ok(userMapper.usersToUsersDTO(userService.findById(id)));
        }

        @GetMapping("/list")
        @Operation(summary = "Get all users", tags = {"User", "Get"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Success",
                        content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                array = @ArraySchema(schema = @Schema(implementation = UserMiniDTO.class)))})
        })
        public ResponseEntity<Collection<UserMiniDTO>> findAll() {
            return ResponseEntity.ok(userMapper.usersToUsersMiniDTO(userService.findAll()));
        }

        @GetMapping("/current")
        @Operation(summary = "Get current user", tags = {"User", "Get"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Success",
                        content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))})
        })
        public ResponseEntity<UserDTO> findCurrentUser(@AuthenticationPrincipal Jwt principal) {
            // TODO Make this 303 See Other
            Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
            String id = userInfo.get("subject");
            return ResponseEntity.ok(userMapper.usersToUsersDTO(userService.findById(id)));
        }

        @GetMapping("/users")
        @Operation(summary = "Get all users", tags = {"User", "Get All"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Success",
                        content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))})
        })
        public ResponseEntity<List<UserDTO>> getAllUsers() {
            List<User> users = userService.getAllUsers();
            List<UserDTO> userDTOs = users.stream()
                    .map(userMapper::usersToUsersDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(userDTOs);
        }

        @PostMapping
        @Operation(summary = "Add a user", tags = {"User", "Post"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Created", content = @Content)
        })
        public ResponseEntity<UserDTO> add(@AuthenticationPrincipal Jwt principal) {
            Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
            String id = userInfo.get("subject");
            String name = userInfo.get("first_name") + " " + userInfo.get("last_name");

            if (userService.existsById(id)) {
                 return null;
            }

            User user = new User();
            user.setId(id);
            user.setName(name);
            userService.add(user);
            URI uri = URI.create("api/v1/users/" + user.getId());

            return ResponseEntity.created(uri).body(userMapper.usersToUsersDTO(userService.findById(id)));
        }

        @PutMapping("{id}")
        @Operation(summary = "Update a user", tags = {"User", "Put"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204", description = "User updated", content = @Content),
                @ApiResponse(responseCode = "400", description = "Bad request, URI does not match request body", content = @Content),
                @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
        })
        public ResponseEntity<UserDTO> update(@RequestBody UserPutDTO entity, @PathVariable String id) {
            if (!userService.existsById(id))
                return ResponseEntity.badRequest().build();

            User users = userMapper.usersPutDTOToUsers(entity);
            users.setId(id);
            userService.update(users);
            return ResponseEntity.ok(userMapper.usersToUsersDTO(userService.findById(id)));
        }
    }
