/*
package accelerate.alumni.alumnibackend.mappers;

import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.model.dtos.PostDTO;
import accelerate.alumni.alumnibackend.service.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDTO toDTO(Post post);
    Post toEntity(PostDTO postDTO);

    protected User mapToUser(Long userId) {
        return userService.findById(userId);
    }

    protected Long mapToUserId(User user) {
        return user.getId();
    }

}
*/
