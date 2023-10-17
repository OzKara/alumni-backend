package accelerate.alumni.alumnibackend.model.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private Long userId;
    private String title;
    private String content;
}
