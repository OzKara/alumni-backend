package accelerate.alumni.alumnibackend.services.users;

import accelerate.alumni.alumnibackend.models.Users;
import accelerate.alumni.alumnibackend.services.CRUDService;

public interface UsersService extends CRUDService<Users, String> {
    Users findById(String id);
}
