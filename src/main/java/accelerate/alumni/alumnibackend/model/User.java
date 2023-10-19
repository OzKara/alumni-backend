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
    private String bio;

    @Column(name = "fun_fact")
    private String funFact;

    @ManyToMany(mappedBy = "users")
    private Set<Group> groups;

    // This is the users "DM" posts
    @OneToMany(mappedBy = "targetUser")
    private Set<Post> posts;

    // This is the users own posts
    @OneToMany(mappedBy = "senderId")
    private Set<Post> posted;

    /*
        @Column(nullable = false)
    private String profile_picture;

    @Column(length = 2000)
    private String biography;

    @Column(length = 50)
    private String fun_fact;
     */
}
