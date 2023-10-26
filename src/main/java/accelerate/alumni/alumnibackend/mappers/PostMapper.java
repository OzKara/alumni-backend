package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupCompressedDTO;
import accelerate.alumni.alumnibackend.model.dtos.post.PostDTO;
import accelerate.alumni.alumnibackend.model.dtos.post.PostEventDTO;
import accelerate.alumni.alumnibackend.model.dtos.post.PostPutDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.SenderDTO;

import org.mapstruct.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "targetGroup", source = "targetGroup", qualifiedByName = "groupToMiniDTO")
    @Mapping(target = "targetUser", source = "targetUser", qualifiedByName = "targetUserToSenderDTO")
    @Mapping(target = "senderId", source = "senderId", qualifiedByName = "userToSenderDTO")
    @Mapping(target = "replyParentId", source = "replyParentId.id")
    @Mapping(target = "replies", source = "replies", qualifiedByName = "postsToPostId")
    @Mapping(target = "createdAt", source = "createdAt")
    PostDTO postToPostDTO(Post post);

    Collection<PostDTO> postToPostDTO(Collection<Post> posts);

    Post postPutDTOToPost(PostPutDTO postPutDTO);

    Collection<PostEventDTO> postToPostEventDTO(Collection<Post> posts);

    @Named(value = "userToSenderDTO")
    default SenderDTO mapSend(User value){
        if(value == null)
            return null;
        SenderDTO sender = new SenderDTO();
        sender.setId(value.getId());
        sender.setName(value.getName());
        sender.setPicture(value.getPicture());
        return sender;
    }

    @Named(value = "targetUserToSenderDTO")
    default SenderDTO mapTargetUser(User user){
        if(user == null)
            return null;
        SenderDTO targetUser = new SenderDTO();
        targetUser.setId(user.getId());
        targetUser.setName(user.getName());
        targetUser.setPicture(user.getPicture());
        return targetUser;
    }

    @Named(value = "groupToMiniDTO")
    default GroupCompressedDTO mapMiniGroup(Group group){
        if(group == null)
            return null;
        GroupCompressedDTO miniGroup = new GroupCompressedDTO();
        miniGroup.setId(group.getId());
        miniGroup.setName((group.getName()));
        return miniGroup;
    }

    @Named(value = "postsToPostId")
    default Set<Long> map(Set<Post> value) {
        if(value == null)
            return new HashSet<>();
        return value.stream()
                .map(Post::getId)
                .collect(Collectors.toSet());
    }
}

