package pl.malopolska.irregularities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.PaymentRequest;
import pl.malopolska.irregularities.model.Project;
import pl.malopolska.irregularities.repository.PaymentRequestRepo;

import java.util.List;

@Service
public class PaymentRequestService {

    @Autowired
    private PaymentRequestRepo paymentRequestRepo;

    public List<PaymentRequest> getAllPaymentRequestByProject(Project project){return paymentRequestRepo.findAllByProject(project);}

    public List<PaymentRequest> getAllByIrregularityId(Long id) {
        return paymentRequestRepo.findAllByIrregularitiesId(id);
    }

    public List<PaymentRequest> getAllPaymentRequestByProjectId(Long id) {
        return paymentRequestRepo.findAllByProjectId(id);
    }
}
