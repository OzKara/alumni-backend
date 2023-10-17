package accelerate.alumni.alumnibackend.controller;

import accelerate.alumni.alumnibackend.mappers.UserMapper;
import accelerate.alumni.alumnibackend.model.dtos.UserDTO;
import accelerate.alumni.alumnibackend.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userMapper.toDTO(userService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll().stream().map(userMapper::toDTO).toList());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userMapper.toDTO(userService.add(userMapper.toEntity(userDTO))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userDTO.setId(id);
        return ResponseEntity.ok(userMapper.toDTO(userService.update(userMapper.toEntity(userDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}