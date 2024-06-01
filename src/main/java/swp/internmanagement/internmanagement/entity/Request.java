package swp.internmanagement.internmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserAccount user;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "request_type", nullable = false, length = 50)
    private String requestType;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "request_content", nullable = false)
    private String requestContent;

    @Column(name = "request_status", nullable = false)
    private Boolean requestStatus = false;

}