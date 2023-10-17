package accelerate.alumni.alumnibackend.model.dtos.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersPostDTO {
    private String name;
    private String picture;
    private String status;
    private String bio;
    private String funFact;
}