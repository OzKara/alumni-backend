package accelerate.alumni.alumnibackend.controllers;

import accelerate.alumni.alumnibackend.models.User;
import accelerate.alumni.alumnibackend.services.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody User user) {
        userService.add(user);
        URI uri = URI.create("user/" + user.getUser_id());
        return ResponseEntity.created(uri).build();
    }
}
