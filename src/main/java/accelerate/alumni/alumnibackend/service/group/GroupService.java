package accelerate.alumni.alumnibackend.service.group;

import accelerate.alumni.alumnibackend.model.Groups;
import accelerate.alumni.alumnibackend.service.CRUDService;

import java.util.Set;

public interface GroupService extends CRUDService<Groups, Integer> {
    Set<Groups> searchResultsWithLimitOffset(String userId, String search, int offset, int limit);
    Groups addUserToGroup(String userId, int groupId);
    Groups removeUserFromGroup(String userId, int groupId);
    Set<Groups> findGroupsWithUser(String userId);
    Groups findByIdWhereUserHasAccess(String userId, int groupId);
    boolean checkIfUserInGroup(String userId, int groupId);
}