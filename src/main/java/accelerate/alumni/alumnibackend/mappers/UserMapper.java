package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.model.dtos.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
