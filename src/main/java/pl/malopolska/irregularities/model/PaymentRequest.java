package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class PaymentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinColumn(name = "irregularity_ID", referencedColumnName = "id")
    List<Irregularity> irregularityList;
    private String paymentRequestNumber;
    @ManyToOne
    @JoinColumn(name = "project_ID",referencedColumnName = "id")
    private Project project;
    private Double totalExpenses;
    private Double qualifiedExpenses;
    private Double qualifiedExpensesAfterValidation;
    private Double funding;
    private Double incomeDeducted;
    private boolean certificated;
    private LocalDate dateOfApproval;
}
