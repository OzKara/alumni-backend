package accelerate.alumni.alumnibackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(length = 50, nullable = false)
    private String first_name;

    @Column(length = 50, nullable = false)
    private String last_name;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String profile_picture;

    @Column(length = 2000)
    private String biography;

    @Column(length = 50)
    private String fun_fact;
}
