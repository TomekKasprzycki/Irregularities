package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.Beneficiary;
import pl.malopolska.irregularities.model.Project;

import java.util.List;

@Repository
@Transactional
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long> {

    Beneficiary findBeneficiaryById(Long id);

    List<Beneficiary> findBeneficiariesByNip(String nip);

    @Query("SELECT b FROM Beneficiary b JOIN FETCH Project p WHERE p=:project")
    Beneficiary findBeneficiaryByProject(@Param("project") Project project);

    @Query(value = "select beneficiary.id, beneficiary.name, beneficiary.nip from beneficiary inner join project on beneficiary.id=project.beneficiary_id " +
            "inner join paymentrequest on project.id=paymentrequest.project_ID inner join paymentrequest_irregularity on " +
            "paymentrequest_irregularity.paymentRequestList_id=paymentrequest.id inner join irregularity on " +
            "paymentrequest_irregularity.irregularityList_id=irregularity.id where irregularity.id=:id group by beneficiary.id", nativeQuery = true)
    Beneficiary findBeneficiaryByIrregularityId(@Param("id") Long id);
}
