package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.PaymentRequest;
import pl.malopolska.irregularities.model.Project;

import java.util.List;

@Repository
@Transactional
public interface PaymentRequestRepo extends JpaRepository<PaymentRequest, Long> {

    List<PaymentRequest> findAllByProject(Project project);

    @Query(value = "select paymentrequest.* from paymentrequest inner join paymentrequest_irregularity on " +
            "paymentrequest.id=paymentrequest_irregularity.paymentRequestList_id inner join irregularity on " +
            "paymentrequest_irregularity.irregularityList_id=irregularity.id where irregularity.id=:id", nativeQuery = true)
    List<PaymentRequest> findAllByIrregularitiesId(@Param("id") Long id);

    List<PaymentRequest> findAllByProjectId(Long id);
}
