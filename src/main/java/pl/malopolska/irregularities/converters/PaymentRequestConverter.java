package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.PaymentRequestDto;
import pl.malopolska.irregularities.model.PaymentRequest;
import pl.malopolska.irregularities.services.IrregularitiesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentRequestConverter {

//    private IrregularityConverter irregularityConverter;
//    private ProjectConverter projectConverter;
//    private IrregularitiesService irregularitiesService;
//
//    private PaymentRequestConverter(IrregularityConverter irregularityConverter,
//                                    ProjectConverter projectConverter,
//                                    IrregularitiesService irregularitiesService){
//        this.irregularitiesService = irregularitiesService;
//        this.irregularityConverter = irregularityConverter;
//        this.projectConverter = projectConverter;
//    }

    public PaymentRequest convertFromDto(PaymentRequestDto paymentRequestDto){
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setId(paymentRequestDto.getId());
        paymentRequest.setPaymentRequestNumber(paymentRequestDto.getPaymentRequestNumber());
        paymentRequest.setCertificated(paymentRequestDto.isCertificated());
        paymentRequest.setDateOfApproval(paymentRequestDto.getDateOfApproval());
        paymentRequest.setFunding(paymentRequestDto.getFunding());
        paymentRequest.setIncomeDeducted(paymentRequestDto.getIncomeDeducted());
//        paymentRequest.setIrregularityList(irregularitiesService.getAllByPaymentRequestId(paymentRequest.getId()));
//        paymentRequest.setProject(projectConverter.convertFromDto(paymentRequestDto.getProjectDto()));
        paymentRequest.setQualifiedExpenses(paymentRequestDto.getQualifiedExpenses());
        paymentRequest.setQualifiedExpensesAfterValidation(paymentRequestDto.getQualifiedExpensesAfterValidation());
        paymentRequest.setTotalExpenses(paymentRequestDto.getTotalExpenses());

        return paymentRequest;
    }

    public PaymentRequestDto convertToDto(PaymentRequest paymentRequest){
        PaymentRequestDto paymentRequestDto = new PaymentRequestDto();
        paymentRequestDto.setId(paymentRequest.getId());
        paymentRequestDto.setPaymentRequestNumber(paymentRequest.getPaymentRequestNumber());
        paymentRequestDto.setCertificated(paymentRequest.isCertificated());
        paymentRequestDto.setDateOfApproval(paymentRequest.getDateOfApproval());
        paymentRequestDto.setFunding(paymentRequest.getFunding());
        paymentRequestDto.setIncomeDeducted(paymentRequest.getIncomeDeducted());
//        paymentRequestDto.setIrregularityDto(irregularityConverter.convertToDto(paymentRequest.getIrregularityList()));
//        paymentRequestDto.setProjectDto(projectConverter.convertToDto(paymentRequest.getProject()));
        paymentRequestDto.setQualifiedExpenses(paymentRequest.getQualifiedExpenses());
        paymentRequestDto.setQualifiedExpensesAfterValidation(paymentRequest.getQualifiedExpensesAfterValidation());
        paymentRequestDto.setTotalExpenses(paymentRequest.getTotalExpenses());

        return paymentRequestDto;
    }

    public List<PaymentRequest> convertFromDto(List<PaymentRequestDto> paymentRequestDtoList){
        List<PaymentRequest> paymentRequests = new ArrayList<>();
        for (PaymentRequestDto paymentRequestDto:paymentRequestDtoList) {
            paymentRequests.add(convertFromDto(paymentRequestDto));
        }
        return paymentRequests;
    }

    public List<PaymentRequestDto> convertToDto(List<PaymentRequest> paymentRequestList){
        List<PaymentRequestDto> paymentRequestsDto = new ArrayList<>();
        for (PaymentRequest paymentRequest:paymentRequestList) {
            paymentRequestsDto.add(convertToDto(paymentRequest));
        }
        return paymentRequestsDto;
    }

}
