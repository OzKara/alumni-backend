package accelerate.alumni.alumnibackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String name;

    @Column(length = 3000)
    private String description;

    @Column
    private String color;

    @Column(name="is_private")
    private boolean isPrivate;

    @ManyToMany
    @JoinTable(
            name = "group_user",
            joinColumns = {@JoinColumn(name = "groups_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")}
    )
    private Set<User> users;

    @OneToMany(mappedBy = "targetGroup")
    private Set<Post> posts;
}
