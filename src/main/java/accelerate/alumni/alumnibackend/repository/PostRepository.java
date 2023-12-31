package accelerate.alumni.alumnibackend.repository;

import accelerate.alumni.alumnibackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select * from Post p where p.parent_id is null and p.group_id = ?1 and ((lower(p.title) like (%?2%) or (lower(p.content) like (%?2%)))) ORDER BY created_at DESC limit ?3 offset ?4", nativeQuery = true)
    Set<Post> findPostsInAGroupWithSearchLimitOffset(int topicId, String search, int limit, int offset);

    @Query(value = "select * from Post p where p.parent_id is null and (p.users_id = ?1 or (p.owner_id = ?1 and users_id IS NOT null)) and ((lower(p.title) like (%?2%) or (lower(p.content) like (%?2%)))) ORDER BY created_at DESC limit ?3 offset ?4 ", nativeQuery = true)
    Set<Post> findPostsToUserWithSearchLimitOffset(String userId, String search, int limit, int offset);

    @Query(value = "select * from Post p where p.users_id = ?1 and p.owner_id = ?2 and ((lower(p.title) like (%?3%) or (lower(p.content) like (%?3%)))) ORDER BY created_at DESC limit ?4 offset ?5", nativeQuery = true)
    Set<Post> findPostsToUserFromSpecificUserWithSearchLimitOffset(String userId, String senderId, String search, int limit, int offset);

    @Query(value = "SELECT * FROM post p WHERE p.is_event = TRUE", nativeQuery = true)
    Collection<Post> findPostThatIsAlsoEvent();

    @Query(value = "SELECT * FROM post WHERE parent_id IS NULL", nativeQuery = true)
    Collection<Post> findByReplyParentIdIsNull();
}
