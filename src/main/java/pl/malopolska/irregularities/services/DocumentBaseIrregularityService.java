package pl.malopolska.irregularities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.DocumentBaseIrregularity;
import pl.malopolska.irregularities.repository.DocumentBaseIrregularityRepo;

import java.util.List;

@Service
public class DocumentBaseIrregularityService {

    @Autowired
    private DocumentBaseIrregularityRepo documentBaseRepo;

    public List<DocumentBaseIrregularity> getAll(){return documentBaseRepo.findAll();}

    public DocumentBaseIrregularity getById(Long documentBaseIrregularityId) {
    return documentBaseRepo.findDocumentBaseIrregularityById(documentBaseIrregularityId);
    }
}
