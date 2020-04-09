package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    private String projectNumber;
    @ManyToOne
    @JoinColumn(name = "beneficiary_id", referencedColumnName = "id")
    Beneficiary beneficiary;
    @OneToMany(mappedBy = "project")
    List<PaymentRequest> paymentRequestList;
    @OneToMany(mappedBy = "project")
    List<Irregularity> irregularityList;

}
