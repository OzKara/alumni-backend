package accelerate.alumni.alumnibackend.exceptions;

import jakarta.persistence.EntityNotFoundException;

/**
 * Custom exception to indicate that a user with a specific ID does not exist.
 */
public class UserNotFoundException extends EntityNotFoundException {

    /**
     * Constructs a new UserNotFoundException with the specified user ID.
     *
     * @param id The ID of the user that was not found.
     */
    public UserNotFoundException(String id) {
        super("User does not exist with ID: " + id);
    }
}
