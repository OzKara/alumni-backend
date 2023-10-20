package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.models.Groups;
import accelerate.alumni.alumnibackend.models.Post;
import accelerate.alumni.alumnibackend.models.dto.group.GroupDTO;
import accelerate.alumni.alumnibackend.models.dto.group.GroupPostDTO;
import accelerate.alumni.alumnibackend.models.dto.group.GroupPutDTO;
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
public interface GroupMapper {
    //@Mapping(target = "posts", qualifiedByName = "postsToPostId")
    //@Mapping(target = "createdAt", source = "createdAt")
    //@Mapping(target = "updatedAt", source = "updatedAt")
    GroupDTO groupToGroupDTO(Groups group);

    Collection<GroupDTO> groupToGroupDTO(Collection<Groups> groups);

    Groups groupPutDTOToGroup(GroupPutDTO groupPutDTO);

    Groups groupPostDTOToGroup(GroupPostDTO groupPostDTO);

    @Named(value = "postsToPostId")
    default Set<Integer> map(Set<Post> value) {
        if (value == null)
            return new HashSet<>();
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}