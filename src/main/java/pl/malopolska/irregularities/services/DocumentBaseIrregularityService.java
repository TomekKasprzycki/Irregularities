package pl.malopolska.irregularities.services;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.DocumentBaseIrregularity;
import pl.malopolska.irregularities.repository.DocumentBaseIrregularityRepo;

import java.util.List;

@Service
public class DocumentBaseIrregularityService {

    private DocumentBaseIrregularityRepo documentBaseRepo;

    private DocumentBaseIrregularityService(DocumentBaseIrregularityRepo documentBaseRepo){
        this.documentBaseRepo = documentBaseRepo;
    }

    public List<DocumentBaseIrregularity> getAll(){return documentBaseRepo.findAll();}

    public DocumentBaseIrregularity getById(Long documentBaseIrregularityId) {
    return documentBaseRepo.findDocumentBaseIrregularityById(documentBaseIrregularityId);
    }
}
