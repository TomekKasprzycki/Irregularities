package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class IrregularityDto {

    private Long id;
    private LocalDateTime created;
    private Long creatorId;
    private LocalDate dateOfIrregularity;
    private Long documentBaseIrregularityId;
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
    private Long beneficiaryId;
    private List<Long> irregularityTypes;
    private Long projectId;

}
