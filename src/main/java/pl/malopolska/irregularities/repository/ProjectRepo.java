package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.Beneficiary;
import pl.malopolska.irregularities.model.PaymentRequest;
import pl.malopolska.irregularities.model.Project;

import java.util.List;

@Repository
@Transactional
public interface ProjectRepo extends JpaRepository<Project, Long> {

    Project findByProjectNumber(String projectNumber);

    @Query("SELECT p FROM Project p WHERE p.id=:id")
    Project findProjectById(@Param("id") Long id);

    List<Project> findAllByBeneficiary(Beneficiary beneficiary);

    @Query("SELECT p FROM Project p JOIN FETCH p.paymentRequestList WHERE :paymentRequest IN (p.paymentRequestList)")
    Project findProjectByPaymentRequest(@Param("paymentRequest") PaymentRequest paymentRequest);

    @Query(value = "select * from project inner join paymentrequest on paymentrequest.project_ID=project.id inner join " +
            "paymentrequest_irregularity on paymentrequest.id=paymentrequest_irregularity.paymentRequestList_id inner join " +
            "irregularity on paymentrequest_irregularity.irregularityList_id=irregularity.id where irregularity.id=:id group by project.id",
            nativeQuery = true)
    Project findProjectByIrregularityId(@Param("id") Long id);

    List<Project> findAllByBeneficiaryId(Long id);

}
