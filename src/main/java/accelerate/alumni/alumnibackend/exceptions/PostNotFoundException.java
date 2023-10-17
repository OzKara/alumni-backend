package accelerate.alumni.alumnibackend.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PostNotFoundException extends EntityNotFoundException {
    public PostNotFoundException(int id) {
        super("Post does not exist with ID: " + id);
    }
}
