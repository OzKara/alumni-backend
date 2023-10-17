package accelerate.alumni.alumnibackend.service.post;

import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
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
}