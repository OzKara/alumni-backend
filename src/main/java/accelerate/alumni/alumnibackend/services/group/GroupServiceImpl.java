package accelerate.alumni.alumnibackend.services.group;

import accelerate.alumni.alumnibackend.exceptions.GroupNotFoundException;
import accelerate.alumni.alumnibackend.models.Group;
import accelerate.alumni.alumnibackend.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group findById(Integer id) {
        return groupRepository.findById(id).orElseThrow(()
                -> new GroupNotFoundException(id));
    }

    @Override
    public Collection<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group add(Group entity) {
        return groupRepository.save(entity);
    }

    @Override
    public Group update(Group entity) {
        return groupRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }
}
