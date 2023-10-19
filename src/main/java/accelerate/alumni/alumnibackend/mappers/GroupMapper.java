package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupDTO;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupPostDTO;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    // @Mapping(target = "posts", qualifiedByName = "postsToPostId")
    //@Mapping(target = "createdAt", source = "createdAt")
    //@Mapping(target = "updatedAt", source = "updatedAt")
    GroupDTO groupToGroupDTO(Group group);

    Collection<GroupDTO> groupToGroupDTO(Collection<Group> groups);

    Group groupPutDTOToGroup(GroupPutDTO groupPutDTO);

    Group groupPostDTOToGroup(GroupPostDTO groupPostDTO);

    @Named(value = "postsToPostId")
    default Set<Long> map(Set<Post> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}