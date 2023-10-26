package accelerate.alumni.alumnibackend.model.dtos.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostEventDTO {
    private String title;
    private String content;
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;
}
