package accelerate.alumni.alumnibackend.model.dtos.post;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostPostDTO {
    private String title;
    private String content;
    private String postTarget;
    private String senderId;
    private Long replyParentId;
    private List<ReplyDTO> replies;
    private String targetUser;
    private int targetGroup;

}