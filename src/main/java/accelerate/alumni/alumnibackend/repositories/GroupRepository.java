package accelerate.alumni.alumnibackend.repositories;

import accelerate.alumni.alumnibackend.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}