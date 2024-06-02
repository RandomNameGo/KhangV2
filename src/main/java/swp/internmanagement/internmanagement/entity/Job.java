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
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "field_id", nullable = false)
    @JsonBackReference
    private Field field;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "job_name", nullable = false, length = 50)
    private String jobName;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "job_description", nullable = false)
    private String jobDescription;

}