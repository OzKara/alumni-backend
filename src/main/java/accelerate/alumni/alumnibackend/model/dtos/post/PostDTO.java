package accelerate.alumni.alumnibackend.model.dtos.post;

import accelerate.alumni.alumnibackend.model.dtos.group.GroupCompressedDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.SenderDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    private Long replyParentId;
    private Set<Long> replies;
    private SenderDTO targetUser;
    private GroupCompressedDTO targetGroup;
}
