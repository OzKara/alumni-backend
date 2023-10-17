package accelerate.alumni.alumnibackend.controllers;

import accelerate.alumni.alumnibackend.models.Group;
import accelerate.alumni.alumnibackend.services.group.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(groupService.findById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Group group) {
        groupService.add(group);
        URI uri = URI.create("group/" + group.getGroup_id());
        return ResponseEntity.created(uri).build();
    }
}
