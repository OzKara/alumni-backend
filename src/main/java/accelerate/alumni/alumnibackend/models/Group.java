package accelerate.alumni.alumnibackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "groups", schema = "public")
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int group_id;

    @Column(length = 50, nullable = false)
    private String group_name;

    @Column(length = 2000, nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creation_date;

    @Column(nullable = false)
    private boolean is_private;

}
