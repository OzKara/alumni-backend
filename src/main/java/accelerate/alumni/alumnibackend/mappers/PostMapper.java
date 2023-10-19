package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupMiniDTO;
import accelerate.alumni.alumnibackend.model.dtos.post.PostDTO;
import accelerate.alumni.alumnibackend.model.dtos.post.PostPostDTO;
import accelerate.alumni.alumnibackend.model.dtos.post.PostPutDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.SenderDTO;
import accelerate.alumni.alumnibackend.service.group.GroupService;
import accelerate.alumni.alumnibackend.service.post.PostService;
import accelerate.alumni.alumnibackend.service.user.UserService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {UserService.class, GroupService.class, PostService.class})
public abstract class PostMapper {
    @Autowired
    protected UserService usersService;

    @Autowired
    protected GroupService groupService;

    @Autowired
    protected PostService postService;

    @Mapping(target = "targetGroup", source = "targetGroup", qualifiedByName = "groupToMiniDTO")
    @Mapping(target = "targetUser", source = "targetUser", qualifiedByName = "targetUserToSenderDTO")
    @Mapping(target = "senderId", source = "senderId", qualifiedByName = "userToSenderDTO")
    @Mapping(target = "replyParentId", source = "replyParentId.id")
    @Mapping(target = "replies", source = "replies", qualifiedByName = "postsToPostId")
    @Mapping(target = "originId", source = "origin.id")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    public abstract PostDTO postToPostDTO(Post post);

    public abstract Collection<PostDTO> postToPostDTO(Collection<Post> posts);

    public abstract Post postPutDTOToPost(PostPutDTO postPutDTO);

    @Mapping(target = "senderId", source = "senderId")
    @Mapping(target = "replyParentId", source = "replyParentId", qualifiedByName = "parentPostIdToPost")
    @Mapping(target = "targetUser", source = "targetUser", qualifiedByName = "userIdToUser")
    @Mapping(target = "targetGroup", source = "targetGroup", qualifiedByName = "groupIdToGroup")
    public abstract Post postPostDTOToPost(PostPostDTO postPostDTO);

    @Named(value = "userToSenderDTO")
    SenderDTO mapSend(User value){
        if(value == null)
            return null;
        SenderDTO sender = new SenderDTO();
        sender.setId(value.getId());
        sender.setName(value.getName());
        sender.setPicture(value.getPicture());
        return sender;
    }

    @Named(value = "targetUserToSenderDTO")
    SenderDTO mapTargetUser(User user){
        if(user == null)
            return null;
        SenderDTO targetUser = new SenderDTO();
        targetUser.setId(user.getId());
        targetUser.setName(user.getName());
        targetUser.setPicture(user.getPicture());
        return targetUser;
    }

    @Named(value = "groupToMiniDTO")
    GroupMiniDTO mapMiniGroup(Group group){
        if(group == null)
            return null;
        GroupMiniDTO miniGroup = new GroupMiniDTO();
        miniGroup.setId(group.getId());
        miniGroup.setName((group.getName()));
        return miniGroup;
    }


    @Named(value = "userIdToUser")
    User map(String value) {
        try {
            return usersService.findById(value);
        } catch (Exception e) {
            return null;
        }
    }

    @Named(value = "groupIdToGroup")
    Group maps(Long value) {
        try {
            return groupService.findById(value);
        } catch (Exception e) {
            return null;
        }
    }

    @Named(value = "parentPostIdToPost")
    Post maper(Long value) {
        try {
            return postService.findById(value);
        } catch (Exception e) {
            return null;
        }
    }

    @Named(value = "postsToPostId")
    Set<Long> map(Set<Post> value) {
        if(value == null)
            return new HashSet<>();
        return value.stream()
                .map(Post::getId)
                .collect(Collectors.toSet());
    }

    java.time.ZonedDateTime timeMap(Instant instant){
        return instant == null ? null : ZonedDateTime.from(instant);
    }
}

