package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.DocumentBaseIrregularity;

@Repository
@Transactional
public interface DocumentBaseIrregularityRepo extends JpaRepository<DocumentBaseIrregularity, Long> {


    DocumentBaseIrregularity findDocumentBaseIrregularityById(Long documentBaseIrregularityId);
}
