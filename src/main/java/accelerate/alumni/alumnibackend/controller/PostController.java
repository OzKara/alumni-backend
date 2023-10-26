package accelerate.alumni.alumnibackend.controller;

import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.mappers.PostMapper;
import accelerate.alumni.alumnibackend.model.dtos.post.*;
import accelerate.alumni.alumnibackend.service.post.PostService;
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
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;
    private final KeycloakInfo keycloakInfo;
    private final UserService userService;

    public PostController(PostService postService, PostMapper postMapper, KeycloakInfo keycloakInfo, UserService userService) {
        this.postService = postService;
        this.postMapper = postMapper;
        this.keycloakInfo = keycloakInfo;
        this.userService = userService;
    }

    @GetMapping("/list")
    @Operation(summary = "Get all posts", tags = {"Posts", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PostDTO.class))),
            @ApiResponse(responseCode = "404", description = "Posts not found", content = @Content)

    })
    public ResponseEntity<Collection<PostDTO>> findAllPosts() {
        Collection<Post> post = postService.findAllTopLevelPosts().stream()
                .sorted(Comparator.comparing(Post::getId).reversed())
                .collect(Collectors.toList());

        return ResponseEntity.ok(postMapper.postToPostDTO(post));
    }

    @GetMapping("/events")
    @Operation(summary = "Get all events", tags = {"Events", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PostEventDTO.class))),
            @ApiResponse(responseCode = "404", description = "Event not found", content = @Content)

    })
    public ResponseEntity<Collection<PostEventDTO>> findAllEvents() {
        Collection<Post> post = postService.findAllEvents().stream()
                .sorted(Comparator.comparing(Post::getId).reversed())
                .collect(Collectors.toList());

        return ResponseEntity.ok(postMapper.postToPostEventDTO(post));
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a post by its id", tags = {"Posts", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PostDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied to the post", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content)

    })
    public ResponseEntity<PostDTO> findById(@AuthenticationPrincipal Jwt principal, @PathVariable Long id) {

        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        Post post = postService.findById(id);
        String userId = userInfo.get("subject");
        return ResponseEntity.ok(postMapper.postToPostDTO(post));
    }

    @PostMapping("/event")
    @Operation(summary = "Add a Event", tags = {"Events", "Post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content)
    })
    public ResponseEntity<Object> addEvent(@AuthenticationPrincipal Jwt principal, @RequestBody PostEventDTO entity) {
        // Get the currently authenticated user's ID from the Keycloak principal
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");

        // Create the Post object with the required fields
        Post post = new Post();
        post.setTitle(entity.getTitle());
        post.setContent(entity.getContent());
        post.setSenderId(userService.findById(userId));
        post.setIsEvent(true);
        post.setStartsAt(entity.getStartsAt());
        post.setEndsAt(entity.getEndsAt());

        postService.add(post);

        // Create the URI for the newly created post
        URI uri = URI.create("api/v1/posts/event" + post.getId());
        return ResponseEntity.created(uri).body(post.getId());
    }

    @PostMapping
    @Operation(summary = "Add a post", tags = {"Posts", "Post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content)
    })
    public ResponseEntity<Object> add(@AuthenticationPrincipal Jwt principal, @RequestBody PostPostDTO entity) {
        // Get the currently authenticated user's ID from the Keycloak principal
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");

        // Create the Post object with the required fields
        Post post = new Post();
        post.setTitle(entity.getTitle());
        post.setContent(entity.getContent());
        post.setSenderId(userService.findById(userId));

        postService.add(post);

        // Create the URI for the newly created post
        URI uri = URI.create("api/v1/posts/" + post.getId());
        return ResponseEntity.created(uri).body(post.getId());
    }

    @PutMapping("{id}")
    @Operation(summary = "Update a post", tags = {"Posts", "Put"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Post updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request, URI does not match request body", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access denied to the post", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content)
    })
    public ResponseEntity<Object> update(@AuthenticationPrincipal Jwt principal, @RequestBody PostPutDTO entity, @PathVariable Long id) {
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");

        if (!postService.existsById(id))
            return ResponseEntity.badRequest().build();
        if (postService.findById(id).getSenderId().getId().equals(userId))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        Post post = postMapper.postPutDTOToPost(entity);
        post.setId(id);
        Post oldPost = postService.findById(id);
        post.setCreatedAt(oldPost.getCreatedAt());
        post.setPostTarget(oldPost.getPostTarget());
        post.setSenderId(oldPost.getSenderId());
        post.setReplyParentId(oldPost.getReplyParentId());
        post.setReplies(oldPost.getReplies());
        post.setTargetUser(oldPost.getTargetUser());
        post.setTargetGroup(oldPost.getTargetGroup());

        postService.update(post);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a post by its id", tags = {"Posts", "Delete"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Post deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content)
    })
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/group/{id}")
    @Operation(summary = "Get all posts in a group", tags = {"Posts", "Group", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = PostDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Posts not found", content = @Content)
    })
    public ResponseEntity<Collection<PostDTO>> findAllPostsInAGroup(@PathVariable int id, @RequestParam Optional<String> search, Optional<Integer> limit, Optional<Integer> offset) {
        String searching = search.orElse("").toLowerCase();
        int limiting = limit.orElse(999999999);
        int offsetting = offset.orElse(0);
        return ResponseEntity.ok(postMapper.postToPostDTO(postService.findAllPostsInGroup(id, searching, limiting, offsetting)));
    }

    @GetMapping("/user")
    @Operation(summary = "Get all posts from a user", tags = {"Posts", "Users", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = PostDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Posts not found", content = @Content)
    })
    public ResponseEntity<Collection<PostDTO>> findAllPostsToAUser(@AuthenticationPrincipal Jwt principal, @RequestParam Optional<String> search, Optional<Integer> limit, Optional<Integer> offset) {
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");
        String searching = search.orElse("").toLowerCase();
        int limiting = limit.orElse(999999999);
        int offsetting = offset.orElse(0);
        return ResponseEntity.ok(postMapper.postToPostDTO(postService.findAllPostsToUser(userId, searching, limiting, offsetting)));
    }

    @GetMapping("/user/{senderId}")
    @Operation(summary = "Get all posts from a user by its id", tags = {"Posts", "Users", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = PostDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Posts not found", content = @Content)
    })
    public ResponseEntity<Collection<PostDTO>> findAllPostsToAUser(@AuthenticationPrincipal Jwt principal, @PathVariable String senderId, @RequestParam Optional<String> search, Optional<Integer> limit, Optional<Integer> offset) {
        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");
        String searching = search.orElse("").toLowerCase();
        int limiting = limit.orElse(999999999);
        int offsetting = offset.orElse(0);
        return ResponseEntity.ok(postMapper.postToPostDTO(postService.findAllPostsToUserFromSpecificUser(userId, senderId, searching, limiting, offsetting)));
    }

    @GetMapping("{id}/replies")
    @Operation(summary = "Get all replies for a post", tags = {"Posts", "Replies", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = PostDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Replies not found", content = @Content)
    })
    public ResponseEntity<Collection<PostDTO>> findRepliesToAPost(@PathVariable Long id) {
        Post post = postService.findById(id);

        List<Post> replies = post.getReplies().stream()
                .sorted(Comparator.comparing(Post::getId))
                .collect(Collectors.toList());

        return ResponseEntity.ok(postMapper.postToPostDTO(replies));
    }


    @PostMapping("/{id}/replies")
    @Operation(summary = "Add a reply to a post", tags = {"Posts", "Replies", "Post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content)
    })
    public ResponseEntity<Object> addReplyToPost(
            @RequestBody ReplyDTO replyDTO,
            @PathVariable Long id,
            @AuthenticationPrincipal Jwt principal
    ) {
        String replyContent = replyDTO.getContent();
        // Load the parent post by postId
        Post parentPost = postService.findById(id);

        if (parentPost == null) {
            return ResponseEntity.notFound().build();
        }
        // This is a reply to a post
        // Create a new post for the reply
        Post replyPost = new Post();

        Map<String, String> userInfo = keycloakInfo.getUserInfo(principal);
        String userId = userInfo.get("subject");
        // Set the reply content and sender ID
        replyPost.setContent(replyContent);
        replyPost.setSenderId(userService.findById(userId)); // Replace with the appropriate user ID

        // Set the origin and replyParentId for the reply
        replyPost.setReplyParentId(parentPost);

        // Add the reply post to the database
        postService.add(replyPost);

        // Get the ID of the newly created reply post
        Long replyPostId = replyPost.getId();

        URI uri = URI.create("api/v1/post/" + replyPostId);
        return ResponseEntity.created(uri).body(replyPostId);
    }
}
