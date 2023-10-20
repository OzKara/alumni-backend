package accelerate.alumni.alumnibackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Set;

@Entity
@Getter
@Setter
public class Users {
    @Id
    private String id;
    private String name;
    private String picture;
    private String status;
    private String bio;
    private String funFact;
    @ManyToMany
    @JoinTable(
            name = "group_user",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "groups_id")}
    )
    private Set<Groups> groups;
    @OneToMany(mappedBy = "targetUser")
    private Set<Post> posts;
    @OneToMany(mappedBy = "senderId")
    private Set<Post> posted;
}
