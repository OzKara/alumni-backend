package accelerate.alumni.alumnibackend.service.post;

import accelerate.alumni.alumnibackend.exceptions.PostNotFoundException;
import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public Collection<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post add(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        if(postRepository.existsById(post.getId())) {
            return postRepository.save(post);
        } else {
            throw new RuntimeException("Post with id " + post.getId() + " does not exist");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return postRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new RuntimeException("Post with id " + id + " does not exist");
        }
    }

    @Override
    public Set<Post> findAllPostsInTopic(int id, String search, int limit, int offset) {
        return postRepository.findPostsInATopicWithSearchLimitOffset(id, search, limit, offset);
    }

    @Override
    public Set<Post> findAllPostsInGroup(int id, String search, int limit, int offset) {
        return postRepository.findPostsInAGroupWithSearchLimitOffset(id, search, limit, offset);
    }

    @Override
    public Set<Post> findAllPostsToUser(String id, String search, int limit, int offset) {
        return postRepository.findPostsToUserWithSearchLimitOffset(id, search, limit, offset);
    }

    @Override
    public Set<Post> findAllPostsToUserFromSpecificUser(String id, String senderId, String search, int limit, int offset) {
        return postRepository.findPostsToUserFromSpecificUserWithSearchLimitOffset(id, senderId, search, limit, offset);
    }

    @Override
    public Set<Post> findPostsUserSubscribedTo(String id, String search, int limit, int offset) {
        if(search == "")
            return postRepository.findPostsThatUserSubscribesToWithLimitOffset(id, search, limit, offset);
        return postRepository.findPostsThatUserSubscribesToWithSearchLimitOffset(id, search, limit, offset);
    }

    @Override
    public Set<Post> findPostsFromTopicUserIsSubscribedTo(String id, String search, int limit, int offset) {
        return postRepository.findAllPostsFromATopicUserIsSubscribedTo(id, search, limit, offset);
    }

    @Override
    public Set<Post> findPostsFromGroupUserIsSubscribedTo(String id, String search, int limit, int offset) {
        return postRepository.findAllPostsFromAGroupUserIsSubscribedTo(id, search, limit, offset);
    }

}