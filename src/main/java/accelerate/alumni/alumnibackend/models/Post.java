package accelerate.alumni.alumnibackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "posts", schema = "public")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private User group_id;

    @ManyToOne
    @JoinColumn(name = "associated_event_id")
    private Event associated_event_id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creation_date;
}
