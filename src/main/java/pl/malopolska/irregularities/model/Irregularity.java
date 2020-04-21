package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Irregularity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    private LocalDateTime created;
    @ManyToOne
    @JoinColumn(name = "user_ID",referencedColumnName = "id")
    private User creator;
    private LocalDate dateOfIrregularity;
    @ManyToMany(mappedBy = "irregularityList")
    private List<PaymentRequest> paymentRequestList;
    @ManyToOne
    @JoinColumn(name="documentBaseIrregularity_ID", referencedColumnName = "id")
    private DocumentBaseIrregularity documentBaseIrregularity;
    @ManyToMany(mappedBy = "irregularityList")
    private List<IrregularityTypes> irregularityTypesList;
    private String description;
    private String controlReferenceNumber;
    private String contractReferenceNumber;
    private boolean visibleToCA;//CA=Certifying Authority
    private boolean actual;
    private Double totalExpenses;
    private Double qualifiedExpenses;
    private boolean reportedInIMS; //IMS=Irregularity Managing System
    private boolean detectedBeforeSendToEC; //EC=European Commission
    private LocalDateTime closedByIB; //IB=Intermediate Body - in case of Technical Assistance IB=MA
    private LocalDateTime closedByMA; //MA=Managing Authority
    private String notes;
    private boolean CAHasEnded;
    @NotNull
    @NotEmpty
    private Long caseID;
    @NIP
    private String contractingInstitutionNIP;
    @ManyToOne
    @JoinColumn(name = "beneficiary_ID", referencedColumnName = "id")
    private Beneficiary beneficiary;
    @ManyToOne
    @JoinColumn(name="project_ID",referencedColumnName = "id")
    private Project project;

}
