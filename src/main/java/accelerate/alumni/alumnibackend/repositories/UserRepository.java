package accelerate.alumni.alumnibackend.repositories;

import accelerate.alumni.alumnibackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
