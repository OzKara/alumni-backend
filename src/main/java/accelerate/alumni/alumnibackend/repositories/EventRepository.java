package accelerate.alumni.alumnibackend.repositories;

import accelerate.alumni.alumnibackend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
