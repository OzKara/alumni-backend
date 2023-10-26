package accelerate.alumni.alumnibackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")  // Using 'users' because 'user' can be a reserved keyword in some databases
@Getter
@Setter
public class User {
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column
    private String picture;

    @Column
    private String status;

    @Column(length = 1000)
    private String bio;

    @Column(name = "fun_fact", length = 2000)
    private String funFact;

    @ManyToMany(mappedBy = "users")
    private Set<Group> groups;

    @OneToMany(mappedBy = "targetUser")
    private Set<Post> posts;

    @OneToMany(mappedBy = "senderId")
    private Set<Post> posted;

}
