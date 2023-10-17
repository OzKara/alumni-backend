package accelerate.alumni.alumnibackend.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class EventNotFoundException extends EntityNotFoundException {
    public EventNotFoundException(int id) {
        super("Event does not exist with ID: " + id);
    }
}
