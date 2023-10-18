package accelerate.alumni.alumnibackend.repositories;

import accelerate.alumni.alumnibackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
