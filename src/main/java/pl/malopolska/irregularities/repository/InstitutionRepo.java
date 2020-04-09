package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.Institution;

import java.util.List;

@Repository
@Transactional
public interface InstitutionRepo extends JpaRepository<Institution, Long> {

    Institution findInstitutionById(Long id);
    List<Institution> findAll();

}
