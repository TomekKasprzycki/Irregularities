package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @NIP
    @NotNull
    private String nip;
    @OneToMany(mappedBy = "beneficiary")
    List<Project> projectList;
    @OneToMany(mappedBy = "beneficiary")
    List<Irregularity> irregularityList;

}
