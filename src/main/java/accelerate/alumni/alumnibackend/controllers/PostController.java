package accelerate.alumni.alumnibackend.controllers;

import accelerate.alumni.alumnibackend.models.Post;
import accelerate.alumni.alumnibackend.services.post.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Post post) {
        postService.add(post);
        URI uri = URI.create("post/" + post.getPost_id());
        return ResponseEntity.created(uri).build();
    }
}
