package accelerate.alumni.alumnibackend.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class DirectMessageNotFoundException extends EntityNotFoundException {
    public DirectMessageNotFoundException(int id) {
        super("Direct message does not exist with ID: " + id);
    }
}
