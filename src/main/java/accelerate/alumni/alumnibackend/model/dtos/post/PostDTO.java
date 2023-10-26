package accelerate.alumni.alumnibackend.model.dtos.post;

import accelerate.alumni.alumnibackend.model.dtos.group.GroupMiniDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.SenderDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private ZonedDateTime createdAt;
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;
    private Boolean isEvent;
    private String title;
    private String content;
    private String postTarget;
    private SenderDTO senderId;
    private Long originId;
    private Long replyParentId;
    private Set<Long> replies;
    private SenderDTO targetUser;
    private GroupMiniDTO targetGroup;
}
