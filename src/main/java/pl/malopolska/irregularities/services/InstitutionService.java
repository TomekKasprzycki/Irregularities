package pl.malopolska.irregularities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.Institution;
import pl.malopolska.irregularities.repository.InstitutionRepo;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepo institutionRepo;

    public Institution getInstitutionByID(Long id){
        return institutionRepo.findInstitutionById(id);
    }

    public List<Institution> getAllInstitutions(){
        return institutionRepo.findAll();
    }

}
