package swp.internmanagement.internmanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "company_description", nullable = false)
    private String companyDescription;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "location", nullable = false, length = 50)
    private String location;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<UserAccount> userAccounts = new ArrayList<>();

}