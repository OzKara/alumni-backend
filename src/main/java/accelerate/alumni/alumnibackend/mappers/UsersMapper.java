package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.models.Groups;
import accelerate.alumni.alumnibackend.models.Post;
import accelerate.alumni.alumnibackend.models.Users;
import accelerate.alumni.alumnibackend.models.dto.users.UsersDTO;
import accelerate.alumni.alumnibackend.models.dto.users.UsersMiniDTO;
import accelerate.alumni.alumnibackend.models.dto.users.UsersPostDTO;
import accelerate.alumni.alumnibackend.models.dto.users.UsersPutDTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    //@Mapping(target = "posts", qualifiedByName = "postsToPostId")
    // @Mapping(target = "posted", qualifiedByName = "postsToPostId")
    //@Mapping(target = "groups", qualifiedByName = "groupsToGroupsId")
    //@Mapping(target = "createdAt", source = "createdAt")
    //@Mapping(target = "updatedAt", source = "updatedAt")
    UsersDTO usersToUsersDTO(Users users);

    Collection<UsersDTO> usersToUsersDTO(Collection<Users> users);

    UsersMiniDTO usersToUsersMiniDTO(Users users);

    Collection<UsersMiniDTO> usersToUsersMiniDTO(Collection<Users> users);

    Users usersPutDTOToUsers(UsersPutDTO usersPutDTO);

    Users usersPostDTOToUsers(UsersPostDTO usersPostDTO);

    @Named(value = "postsToPostId")
    default Set<Integer> map(Set<Post> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }

    @Named(value = "groupsToGroupsId")
    default Set<Integer> mapGroups(Set<Groups> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}