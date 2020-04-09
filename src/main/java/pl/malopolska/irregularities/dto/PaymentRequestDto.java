package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentRequestDto {

    private Long id;
    //List<IrregularityDto> irregularityDtoList;
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
