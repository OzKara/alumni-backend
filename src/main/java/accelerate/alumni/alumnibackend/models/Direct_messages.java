package accelerate.alumni.alumnibackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "direct_messages", schema = "public")
@Getter
@Setter
public class Direct_messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int message_id;

    @ManyToOne
    @JoinColumn(name = "sender_user_id", nullable = false)
    private User senderUser;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id", nullable = false)
    private User receiverUser;

    @Column(length = 2000, nullable = false)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;
}
