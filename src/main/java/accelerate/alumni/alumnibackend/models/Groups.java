package accelerate.alumni.alumnibackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String color;
    @Column(name="is_private")
    private boolean isPrivate;
    @ManyToMany(mappedBy = "groups")
    private Set<Users> users;
    @OneToMany(mappedBy = "targetGroup")
    private Set<Post> posts;
}