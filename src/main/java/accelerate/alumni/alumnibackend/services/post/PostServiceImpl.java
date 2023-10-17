package accelerate.alumni.alumnibackend.services.post;

import accelerate.alumni.alumnibackend.exceptions.PostNotFoundException;
import accelerate.alumni.alumnibackend.models.Post;
import accelerate.alumni.alumnibackend.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findById(Integer id) {
        return postRepository.findById(id).orElseThrow(()
                -> new PostNotFoundException(id));
    }

    @Override
    public Collection<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post add(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public Post update(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }
}
