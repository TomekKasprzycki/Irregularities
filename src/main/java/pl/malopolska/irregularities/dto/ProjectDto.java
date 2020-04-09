package pl.malopolska.irregularities.dto;

import lombok.Data;

@Data
public class ProjectDto {

    private Long id;
    private String projectNumber;
    Long beneficiaryId;
    //List<PaymentRequestDto> paymentRequestDtoList;

}
