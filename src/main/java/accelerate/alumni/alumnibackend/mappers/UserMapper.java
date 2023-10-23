package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.model.dtos.user.UserDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.UserMiniDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.UserPostDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.UserPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //@Mapping(target = "posts", qualifiedByName = "postsToPostId")
    //@Mapping(target = "posted", qualifiedByName = "postsToPostId")
    @Mapping(target = "groups", qualifiedByName = "groupsToGroupsId")
    //@Mapping(target = "topics", qualifiedByName = "topicsToTopicsId")
    //@Mapping(target = "createdAt", source = "createdAt")
    //@Mapping(target = "updatedAt", source = "updatedAt")
    UserDTO usersToUsersDTO(User user);

    Collection<UserDTO> usersToUsersDTO(Collection<User> users);

    UserMiniDTO usersToUsersMiniDTO(User user);

    Collection<UserMiniDTO> usersToUsersMiniDTO(Collection<User> users);

    User usersPutDTOToUsers(UserPutDTO userPutDTO);

    User usersPostDTOToUsers(UserPostDTO userPostDTO);

    @Named(value = "postsToPostId")
    default Set<Long> map(Set<Post> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }

    @Named(value = "groupsToGroupsId")
    default Set<Long> mapGroups(Set<Group> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}