package accelerate.alumni.alumnibackend.service.group;

import accelerate.alumni.alumnibackend.exceptions.GroupNotFoundException;
import accelerate.alumni.alumnibackend.model.Group;
import accelerate.alumni.alumnibackend.repository.GroupRepository;
import accelerate.alumni.alumnibackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository usersRepository;

    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.usersRepository = userRepository;
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new GroupNotFoundException(id));
    }

    @Override
    public Collection<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group add(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return groupRepository.existsById(id);
    }

    @Override
    public Set<Group> searchResultsWithLimitOffset(String userId, String search, int offset, int limit) {
        return groupRepository.findGroupsByNameWithLimitOffset(userId, search, limit, offset);
    }

    @Override
    public Group addUserToGroup(String userId, Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException(groupId));
        group.getUsers().add(usersRepository.findById(userId).get());

        return groupRepository.save(group);
    }

    @Override
    public Group removeUserFromGroup(String userId, Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException(groupId));
        boolean executed = group.getUsers().remove(usersRepository.findById(userId).get());
        if (!executed)
            return group;

        return groupRepository.save(group);
    }

    @Override
    public Set<Group> findGroupsWithUser(String userId) {
        return groupRepository.findGroupsAUserIsIn(userId);
    }

    @Override
    public Group findByIdWhereUserHasAccess(String userId, Long groupId) {
        return groupRepository.findGroupByIdIfUserHasAccess(userId, groupId);
    }

    @Override
    public boolean checkIfUserInGroup(String userId, Long groupId) {
        return groupRepository.checkIfUserIsInGroup(userId, groupId);
    }
}
