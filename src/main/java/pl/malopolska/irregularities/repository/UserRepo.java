package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.User;

import java.util.List;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.role JOIN FETCH u.institution WHERE u.email=:email")
    User findUserByEmail(@Param("email") String email);

    @Query("SELECT count(u) FROM User u WHERE u.email=:email")
    Long countUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u JOIN FETCH u.role JOIN FETCH u.institution WHERE u.id=:id")
    User findUserById(@Param("id") Long id);

    @Query(value="SELECT id, active, email, first_name, last_name, institution_id, role_id FROM user WHERE user.active=1", nativeQuery = true)
    List<User> findAllActive();

    @Query(value="SELECT id, active, email, first_name, last_name, institution_id, role_id FROM user WHERE user.active=0", nativeQuery = true)
    List<User> findAllUnActive();

    @Query(value = "update user set user.active=1 where user.id=:id", nativeQuery = true)
    User setUserActive(@Param("id") Long id);
}
