package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.model.dtos.user.UserDTO;
import accelerate.alumni.alumnibackend.model.dtos.user.UserCompressedDTO;
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
    @Mapping(target = "groups", qualifiedByName = "groupsToGroupsId")
    UserDTO usersToUsersDTO(User user);

    Collection<UserDTO> usersToUsersDTO(Collection<User> users);

    UserCompressedDTO usersToUsersMiniDTO(User user);

    Collection<UserCompressedDTO> usersToUsersMiniDTO(Collection<User> users);

    User usersPutDTOToUsers(UserPutDTO userPutDTO);


    @Named(value = "groupsToGroupsId")
    default Set<Long> mapGroups(Set<Group> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
