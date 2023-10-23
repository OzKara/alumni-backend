package accelerate.alumni.alumnibackend.controller;

import accelerate.alumni.alumnibackend.mappers.GroupMapper;
import accelerate.alumni.alumnibackend.mappers.UserMapper;
import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupDTO;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupPostDTO;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupPutDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.UserDTO;
import accelerate.alumni.alumnibackend.service.group.GroupService;
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

@PreAuthorize("hasRole('user')")
@RestController
@RequestMapping(path = "api/v1/group")
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;
    private final UserService userService;
    private final UserMapper userMapper;
    private final KeycloakInfo keycloakInfo;

    public GroupController(GroupService groupService, GroupMapper groupMapper, UserService userService, UserMapper userMapper, KeycloakInfo keycloakInfo) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
        this.userService = userService;
        this.userMapper = userMapper;
        this.keycloakInfo = keycloakInfo;
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a group by its id", tags = {"Group", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = GroupDTO.class))),
            @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
    })
    public ResponseEntity<GroupDTO> findById(@PathVariable Long id, @AuthenticationPrincipal Jwt principal) {
        if (!groupService.existsById(id))
            return ResponseEntity.notFound().build();
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");
        GroupDTO group = groupMapper.groupToGroupDTO(groupService.findByIdWhereUserHasAccess(userId, id));
        if (group == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        return ResponseEntity.ok(group);
    }

    @GetMapping
    @Operation(summary = "Get all groups", tags = {"Group", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = GroupDTO.class)))})
    })
    public ResponseEntity<Collection<GroupDTO>> findAll(@RequestParam Optional<String> search, Optional<Integer> limit, Optional<Integer> offset, @AuthenticationPrincipal Jwt principal) {
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");
        return ResponseEntity.ok(groupMapper.groupToGroupDTO(
                groupService.searchResultsWithLimitOffset(userId, search.orElse("").toLowerCase(), offset.orElse(0), limit.orElse(99999999))));
    }

    @PostMapping
    @Operation(summary = "Add a group", tags = {"Group", "Post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content)
    })
    public ResponseEntity<Object> add(@RequestBody GroupPostDTO entity, @AuthenticationPrincipal Jwt principal) {
        Group group = groupMapper.groupPostDTOToGroup(entity);
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String id = userInfo.get("subject");;
        Set<User> user = new HashSet<>();
        user.add(userService.findById(id));
        group.setUsers(user);
        groupService.add(group);
        URI uri = URI.create("api/v1/group/" + group.getId());
        return ResponseEntity.created(uri).body(group.getId());
    }

    @PutMapping("{id}")
    @Operation(summary = "Update a group", tags = {"Group", "Put"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Group updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request, URI does not match request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
    })
    public ResponseEntity<Object> update(@RequestBody GroupPutDTO entity, @PathVariable Long id, @AuthenticationPrincipal Jwt principal) {
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        if (!groupService.existsById(id))
            return ResponseEntity.badRequest().build();
        if (!groupService.checkIfUserInGroup(userInfo.get("subject"), id))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        Group group = groupMapper.groupPutDTOToGroup(entity);
        Group oldGroup = groupService.findById(id);
        group.setId(id);
        group.setUsers(oldGroup.getUsers());
        groupService.update(group);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{id}/join")
    @Operation(summary = "Add a user to a group", tags = {"Group", "Users", "Post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content),
            @ApiResponse(responseCode = "401", description = "Forbidden", content = @Content)
    })
    public ResponseEntity<Object> addUserToGroup( @PathVariable Long id, @RequestParam Optional<String> user, @AuthenticationPrincipal Jwt principal) {
        if (!groupService.existsById(id))
            return ResponseEntity.badRequest().build();

        boolean privateGroup = groupService.findById(id).isPrivate();
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        if (privateGroup) {
            if (!groupService.checkIfUserInGroup(userInfo.get("subject"), id))
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String userId = user.orElse("");
        if (userId.equals("")) {
            userId = userInfo.get("subject");
        }
        groupService.addUserToGroup(userId, id);
        return ResponseEntity.noContent().build();
    }

    /*@PutMapping("{id}/leave")
    @Operation(summary = "Remove a user from a group", tags = {"Group", "Users", "Put"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Group updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request, URI does not match request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
    })
    public ResponseEntity<Object> removeUserFromGroup( @PathVariable Long id, @AuthenticationPrincipal Jwt principal) {
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        if (!groupService.existsById(id))
            return ResponseEntity.badRequest().build();

        String userId = userInfo.get("subject");
        groupService.removeUserFromGroup(userId, id);
        return ResponseEntity.noContent().build();
    }*/

    @GetMapping("/user")
    @Operation(summary = "Get all groups for a user", tags = {"Group", "Users", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = GroupDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
    })
    public ResponseEntity<Collection<GroupDTO>> findGroupsForAUser(@AuthenticationPrincipal Jwt principal) {
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");
        return ResponseEntity.ok(groupMapper.groupToGroupDTO(groupService.findGroupsWithUser(userId)));
    }

    @GetMapping("{id}/user/list")
    @Operation(summary = "Get all users in a group", tags = {"Group", "Users", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
    })
    public ResponseEntity<Collection<UserDTO>> findAllMembers(@PathVariable Long id) {
        Group groups = groupService.findById(id);
        return ResponseEntity.ok(userMapper.usersToUsersDTO(groups.getUsers()));
    }
}
