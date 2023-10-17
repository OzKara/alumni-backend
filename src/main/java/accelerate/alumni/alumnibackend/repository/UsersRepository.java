package accelerate.alumni.alumnibackend.repository;

import accelerate.alumni.alumnibackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
