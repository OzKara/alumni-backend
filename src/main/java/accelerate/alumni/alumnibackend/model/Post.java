package accelerate.alumni.alumnibackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @Column(name = "starts_at", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startsAt;

    @Column(name = "ends_at", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endsAt;

    @Column(name = "is_event", columnDefinition = "boolean default false")
    private  boolean isEvent;

    @Column
    private String title;

    @Column(length = 4000)
    private String content;

    @Column(name = "post_target")
    private String postTarget;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Post origin;

    @OneToMany(mappedBy = "origin")
    private Set<Post> thread;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User senderId;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post replyParentId;

    @OneToMany(mappedBy = "replyParentId")
    private Set<Post> replies;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User targetUser;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group targetGroup;

}