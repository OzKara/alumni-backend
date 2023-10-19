package accelerate.alumni.alumnibackend.model.dtos.post;

import accelerate.alumni.alumnibackend.model.dtos.group.GroupMiniDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.SenderDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private java.time.ZonedDateTime createdAt;
    private java.time.ZonedDateTime updatedAt;
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
