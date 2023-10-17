package accelerate.alumni.alumnibackend.repositories;

import accelerate.alumni.alumnibackend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
