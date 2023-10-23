package accelerate.alumni.alumnibackend.model.dtos.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private String id;
    private String name;
    private String picture;
    private String status;
    private String bio;
    private String funFact;
    private Set<Long> groups;
}
