/*package accelerate.alumni.alumnibackend.controller;

import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.mappers.PostMapper;
import accelerate.alumni.alumnibackend.model.dtos.PostDTO;
import accelerate.alumni.alumnibackend.service.post.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        Post post = postService.findById(id);
        if (post != null) {
            return ResponseEntity.ok(postMapper.toDTO(post));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<Post> posts = (List<Post>) postService.findAll();
        List<PostDTO> postDTOs = posts.stream()
                .map(postMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(postDTOs);
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        Post post = postMapper.toEntity(postDTO);
        post = postService.add(post);
        return ResponseEntity.ok(postMapper.toDTO(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        if (!id.equals(postDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Post post = postMapper.toEntity(postDTO);
        post = postService.update(post);
        return ResponseEntity.ok(postMapper.toDTO(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (!postService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}*/