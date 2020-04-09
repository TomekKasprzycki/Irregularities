package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.Irregularity;
import java.util.List;

@Repository
@Transactional
public interface IrregularityRepo extends JpaRepository<Irregularity, Long> {


    @Query(value = "select * from irregularity inner join paymentrequest_irregularity on irregularity.id=paymentrequest_irregularity.irregularityList_id " +
            "inner join paymentrequest on paymentrequest_irregularity.paymentRequestList_id=paymentrequest.id inner join " +
            "user on irregularity.user_ID=user.id inner join role on user.role_id=role.id inner join institution on user.institution_id=institution.id " +
            " group by irregularity.id", nativeQuery = true)
    List<Irregularity> findAllIrregularitiesWithDetails();

    @Query(value = "select irregularity.* from irregularity inner join paymentrequest_irregularity on irregularity.id=paymentrequest_irregularity.irregularityList_id " +
            "inner join paymentrequest on paymentrequest_irregularity.paymentRequestList_id=paymentrequest.id inner join project on " +
            "paymentrequest.project_ID=project.id inner join beneficiary on project.beneficiary_id=beneficiary.id where beneficiary.nip=:nip group by irregularity.id", nativeQuery = true)
    List<Irregularity> findAllIrregularitiesWithDetailsByBeneficiaryNIP(@Param("nip") String nip);

    @Query(value = "select irregularity.* from irregularity inner join irregularitytypes_irregularity on " +
            "irregularity.id=irregularitytypes_irregularity.irregularityList_id inner join irregularitytypes on " +
            "irregularitytypes_irregularity.irregularityTypesList_id=irregularitytypes.id where irregularitytypes.id=:irregularityTypeId"
            , nativeQuery = true)
    List<Irregularity> findIrregularitiesByTypeID(Long irregularityTypeId);

    @Query(value = "select irregularity.* from irregularity inner join paymentrequest_irregularity on irregularity.id=paymentrequest_irregularity.irregularityList_id " +
            " inner join paymentrequest on paymentrequest_irregularity.paymentRequestList_id=paymentrequest.id where paymentrequest.id=:id", nativeQuery = true)
    List<Irregularity> findAllByPaymentRequestId(@Param("id") Long id);
}
