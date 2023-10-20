package accelerate.alumni.alumnibackend.models.dto.users;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UsersDTO {
    private String id;
    private String name;
    private String picture;
    private String status;
    private String bio;
    private String funFact;
    private Set<Integer> groups; // Ensure the field name matches the entity field
}
