package swp.internmanagement.internmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "mentor_feedback_intern")
public class MentorFeedbackIntern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mentor_id", referencedColumnName = "user_id",nullable = false)
    private UserAccount mentor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "intern_id", referencedColumnName = "user_id",nullable = false)
    private UserAccount intern;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "feedback_content", nullable = false)
    private String feedbackContent;

}