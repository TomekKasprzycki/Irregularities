package pl.malopolska.irregularities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.Beneficiary;
import pl.malopolska.irregularities.model.PaymentRequest;
import pl.malopolska.irregularities.model.Project;
import pl.malopolska.irregularities.repository.ProjectRepo;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project getByProjectNumber(String projectNumber){return projectRepo.findByProjectNumber(projectNumber);}

    public Project getProjectById(Long id){return projectRepo.findProjectById(id);}

    public Project getProjectByPaymentRequest(PaymentRequest paymentRequest){return projectRepo.findProjectByPaymentRequest(paymentRequest);}

    public List<Project> getAllProjectByBeneficiary(Beneficiary beneficiary){return projectRepo.findAllByBeneficiary(beneficiary);}

    public Project getProjectByIrregularityId(Long id){return projectRepo.findProjectByIrregularityId(id);}

    public List<Project> getAllProjectsByBeneficiaryId(Long id){return projectRepo.findAllByBeneficiaryId(id);}

}
