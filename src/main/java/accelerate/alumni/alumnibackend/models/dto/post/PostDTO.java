package accelerate.alumni.alumnibackend.models.dto.post;

import lombok.Getter;
import lombok.Setter;
import accelerate.alumni.alumnibackend.models.dto.group.GroupMiniDTO;
import accelerate.alumni.alumnibackend.models.dto.users.SenderDTO;

import java.util.Set;

@Getter
@Setter
public class PostDTO {
    private int id;
    private java.time.ZonedDateTime createdAt;
    private java.time.ZonedDateTime updatedAt;
    private String title;
    private String content;
    private String postTarget;
    private SenderDTO senderId;
    private int originId;
    private int replyParentId;
    private Set<Integer> replies;
    private SenderDTO targetUser;
    private GroupMiniDTO targetGroup;
}
