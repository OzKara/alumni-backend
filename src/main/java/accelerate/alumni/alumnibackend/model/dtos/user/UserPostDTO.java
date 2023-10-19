package accelerate.alumni.alumnibackend.model.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostDTO {
    private String name;
    private String picture;
    private String status;
    private String bio;
    private String funFact;
}