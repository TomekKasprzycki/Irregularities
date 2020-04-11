package pl.malopolska.irregularities.services;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.Irregularity;
import pl.malopolska.irregularities.repository.IrregularityRepo;

import java.util.List;

@Service
public class IrregularitiesService {

    private IrregularityRepo irregularityRepo;

    private IrregularitiesService(IrregularityRepo irregularityRepo){
        this.irregularityRepo = irregularityRepo;
    }

    public List<Irregularity> getAllToShow(){return irregularityRepo.findAll();}

    public List<Irregularity> getAllIrregularitiesWithDetails(){return irregularityRepo.findAllIrregularitiesWithDetails();}

    public List<Irregularity> getAllIrregularitiesWithDetailsByBeneficiaryNIP(String nip){
        return irregularityRepo.findAllIrregularitiesWithDetailsByBeneficiaryNIP(nip);
    }

    public List<Irregularity> getAll(){return irregularityRepo.findAll();}

    public List<Irregularity> getAllByIrregularityTypesId(Long irregularityTypeId) {
        return irregularityRepo.findIrregularitiesByTypeID(irregularityTypeId);
    }

    public List<Irregularity> getAllByPaymentRequestId(Long id) {
        return irregularityRepo.findAllByPaymentRequestId(id);
    }

    public Irregularity save(Irregularity irregularity) {
        return irregularityRepo.save(irregularity);
    }
}