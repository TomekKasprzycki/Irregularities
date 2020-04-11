package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {

    private Long id;
    private String projectNumber;
    BeneficiaryDto beneficiaryDto;
    List<PaymentRequestDto> paymentRequestDto;

}
