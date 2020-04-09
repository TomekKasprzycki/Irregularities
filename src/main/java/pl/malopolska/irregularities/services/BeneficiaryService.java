package pl.malopolska.irregularities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.Beneficiary;
import pl.malopolska.irregularities.model.Project;
import pl.malopolska.irregularities.repository.BeneficiaryRepo;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepo beneficiaryRepo;

    public Beneficiary getBeneficiaryByProject(Project project){return beneficiaryRepo.findBeneficiaryByProject(project);}

    public Beneficiary getBeneficiary(Long id){return beneficiaryRepo.findBeneficiaryById(id);}

    public List<Beneficiary> getBeneficiariesByNIP(String nip){return beneficiaryRepo.findBeneficiariesByNip(nip);}

    public List<Beneficiary> getAllBeneficiaries(){return beneficiaryRepo.findAll();}

    public Beneficiary getBeneficiaryByIrregularityId(Long id) {
        return beneficiaryRepo.findBeneficiaryByIrregularityId(id);
    }

}
