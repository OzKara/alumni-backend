package accelerate.alumni.alumnibackend.service.user;

import accelerate.alumni.alumnibackend.model.User;
import accelerate.alumni.alumnibackend.service.CRUDService;

import java.util.List;

public interface UserService extends CRUDService<User, String> {
    List<User> getAllUsers();

}
