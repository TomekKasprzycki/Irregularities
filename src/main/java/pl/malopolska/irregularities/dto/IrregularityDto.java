package pl.malopolska.irregularities.dto;

import lombok.Data;
import pl.malopolska.irregularities.model.Beneficiary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class IrregularityDto {

    private Long id;
    private LocalDateTime created;
    private UserDto userDto; //creator
    private LocalDate dateOfIrregularity;
    private DocumentBaseIrregularityDto documentBaseIrregularityDto;
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
    private Long caseID;
    private String contractingInstitutionNIP;
    private BeneficiaryDto beneficiaryDto;
    private List<IrregularityTypesDto> irregularityTypesDto;
    private ProjectDto projectDto;
    private List<PaymentRequestDto> paymentRequestDto;

}
