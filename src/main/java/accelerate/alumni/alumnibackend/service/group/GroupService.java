package accelerate.alumni.alumnibackend.service.group;

import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.service.CRUDService;

import java.util.Set;

public interface GroupService extends CRUDService<Group, Long> {
    Set<Group> searchResultsWithLimitOffset(String userId, String search, int offset, int limit);
    Group addUserToGroup(String userId, Long groupId);
    Group removeUserFromGroup(String userId, Long groupId);
    Set<Group> findGroupsWhereUserIsMember(String userId);
    Group findByIdWhereUserHasAccess(String userId, Long groupId);
    boolean checkIfUserIsInGroup(String userId, Long groupId);
}
