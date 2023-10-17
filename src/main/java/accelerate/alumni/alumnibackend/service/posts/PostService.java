package accelerate.alumni.alumnibackend.service.posts;

import accelerate.alumni.alumnibackend.model.Post;
import accelerate.alumni.alumnibackend.service.CRUDService;

import java.util.Collection;
import java.util.Set;

public interface PostService extends CRUDService<Post, Integer> {
    Post findById(Integer id);

    Collection<Post> findAll();

    Set<Post> findAllPostsInTopic(int id, String search, int limit, int offset);
    Set<Post> findAllPostsInGroup(int id, String search, int limit, int offset);
    Set<Post> findAllPostsToUser(String id, String search, int limit, int offset);
    Set<Post> findAllPostsToUserFromSpecificUser(String id, String senderId, String search, int limit, int offset);
    Set<Post> findPostsUserSubscribedTo(String id, String search, int limit, int offset);
    Set<Post> findPostsFromTopicUserIsSubscribedTo(String id, String search, int limit, int offset);
    Set<Post> findPostsFromGroupUserIsSubscribedTo(String id, String search, int limit, int offset);
}