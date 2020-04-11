package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PaymentRequestDto {

    private Long id;
    List<IrregularityDto> irregularityDto;
    private String paymentRequestNumber;
    private ProjectDto projectDto;
    private Double totalExpenses;
    private Double qualifiedExpenses;
    private Double qualifiedExpensesAfterValidation;
    private Double funding;
    private Double incomeDeducted;
    private boolean certificated;
    private LocalDate dateOfApproval;

}
