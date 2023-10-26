package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupDTO;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupPostDTO;
import accelerate.alumni.alumnibackend.model.dtos.group.GroupPutDTO;
import org.mapstruct.Mapper;


import java.util.Collection;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupDTO groupToGroupDTO(Group group);

    Collection<GroupDTO> groupToGroupDTO(Collection<Group> groups);

    Group groupPutDTOToGroup(GroupPutDTO groupPutDTO);

    Group groupPostDTOToGroup(GroupPostDTO groupPostDTO);

}
