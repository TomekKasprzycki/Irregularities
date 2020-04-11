package pl.malopolska.irregularities.services;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.IrregularityTypes;
import pl.malopolska.irregularities.repository.IrregularityTypesRepo;

import java.util.List;

@Service
public class IrregularityTypesService {

    private IrregularityTypesRepo irregularityTypesRepo;

    private IrregularityTypesService(IrregularityTypesRepo irregularityTypesRepo){
        this.irregularityTypesRepo = irregularityTypesRepo;
    }

    public List<IrregularityTypes> irregularityTypesList(){return irregularityTypesRepo.findAll();}


    public List<IrregularityTypes> getAllByIrregularityId(Long id) {
        return irregularityTypesRepo.findAllByIrregularityId(id);
    }

    public IrregularityTypes getById(Long id) {
        return irregularityTypesRepo.findIrregularityTypesById(id);
    }
}
