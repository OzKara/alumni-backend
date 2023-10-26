package accelerate.alumni.alumnibackend.service.post;

import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.service.CRUDService;

import java.util.Collection;
import java.util.Set;

public interface PostService extends CRUDService<Post, Long> {
    Set<Post> findAllPostsInGroup(int id, String search, int limit, int offset);
    Set<Post> findAllPostsToUser(String id, String search, int limit, int offset);
    Set<Post> findAllPostsToUserFromSpecificUser(String id, String senderId, String search, int limit, int offset);
    Collection<Post> findAllTopLevelPosts();
    Collection<Post> findAllEvents();
}