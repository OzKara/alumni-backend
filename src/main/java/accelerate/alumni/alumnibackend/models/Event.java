package accelerate.alumni.alumnibackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "events", schema = "public")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date start_date;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date end_date;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creation_date;

    @Column(length = 50, nullable = false)
    private String participants;


}
