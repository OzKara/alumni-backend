package accelerate.alumni.alumnibackend.repository;

import accelerate.alumni.alumnibackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
