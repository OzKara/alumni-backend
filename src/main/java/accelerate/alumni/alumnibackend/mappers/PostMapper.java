package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.models.Groups;
import accelerate.alumni.alumnibackend.models.Post;
import accelerate.alumni.alumnibackend.models.Users;
import accelerate.alumni.alumnibackend.models.dto.group.GroupMiniDTO;
import accelerate.alumni.alumnibackend.models.dto.post.PostDTO;
import accelerate.alumni.alumnibackend.models.dto.post.PostPostDTO;
import accelerate.alumni.alumnibackend.models.dto.post.PostPutDTO;
import accelerate.alumni.alumnibackend.models.dto.users.SenderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    public abstract PostDTO postToPostDTO(Post post);
    public abstract Collection<PostDTO> postToPostDTO(Collection<Post> posts);
    public abstract Post postPutDTOToPost(PostPutDTO postPutDTO);
    public abstract Post postPostDTOToPost(PostPostDTO postPostDTO);

    @Named(value = "userToSenderDTO")
    SenderDTO mapUserToSenderDTO(Users value) {
        if (value == null)
            return null;
        SenderDTO sender = new SenderDTO();
        sender.setId(value.getId());
        sender.setName(value.getName());
        sender.setPicture(value.getPicture());
        return sender;
    }

    @Named(value = "targetUserToSenderDTO")
    SenderDTO mapTargetUserToSenderDTO(Users user) {
        if (user == null)
            return null;
        SenderDTO targetUser = new SenderDTO();
        targetUser.setId(user.getId());
        targetUser.setName(user.getName());
        targetUser.setPicture(user.getPicture());
        return targetUser;
    }

    @Named(value = "groupToMiniDTO")
    GroupMiniDTO mapGroupToMiniDTO(Groups group) {
        if (group == null)
            return null;
        GroupMiniDTO miniGroup = new GroupMiniDTO();
        miniGroup.setId(group.getId());
        miniGroup.setName(group.getName());
        return miniGroup;
    }

    @Named(value = "parentPostIdToPost")
    Post mapParentPostIdToPost(Integer value) {
        if (value == null)
            return null;
        Post post = new Post();
        post.setId(value);
        return post;
    }

    @Named(value = "postsToPostId")
    Set<Integer> mapPostsToPostId(Set<Post> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(Post::getId)
                .collect(Collectors.toSet());
    }

    ZonedDateTime timeMap(Instant instant) {
        return instant == null ? null : ZonedDateTime.from(instant);
    }
}
