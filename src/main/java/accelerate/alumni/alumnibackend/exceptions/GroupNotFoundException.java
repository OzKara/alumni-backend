package accelerate.alumni.alumnibackend.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class GroupNotFoundException extends EntityNotFoundException {
    public GroupNotFoundException(int id) {
        super("Group does not exist with ID: " + id);
    }
}
