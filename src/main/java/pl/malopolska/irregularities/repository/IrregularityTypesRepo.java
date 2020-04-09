package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.IrregularityTypes;

import java.util.List;

@Repository
@Transactional
public interface IrregularityTypesRepo extends JpaRepository<IrregularityTypes, Long> {

    @Query(value = "select irregularitytypes.* from irregularitytypes inner join irregularitytypes_irregularity on " +
            "irregularitytypes.id=irregularitytypes_irregularity.irregularityTypesList_id inner join irregularity on " +
            "irregularitytypes_irregularity.irregularityList_id=irregularity.id where irregularity.id=:id", nativeQuery = true)
    List<IrregularityTypes> findAllByIrregularityId(@Param("id") Long id);

    IrregularityTypes findIrregularityTypesById(Long id);
}
