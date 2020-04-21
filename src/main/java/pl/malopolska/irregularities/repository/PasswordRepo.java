package pl.malopolska.irregularities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.irregularities.model.Passwords;
import pl.malopolska.irregularities.model.User;

import javax.persistence.NamedNativeQueries;
import java.util.List;

@Repository
@Transactional
public interface PasswordRepo extends JpaRepository<Passwords, Long> {

    @Query("select count (p) from Passwords p where p.user=:user")
    int countAllByUser(@Param("user") User user);

    @Query("select p from Passwords p join fetch User u on u=p.user where u=:user")
    List<Passwords> getAllUserPasswords(User user);

    @Query("select p from Passwords p join fetch User u on u=p.user where u=:user order by p.createdDate desc")
    Passwords getFirstUserPassword(User user);

    @Query("select p.password from Passwords p join fetch User u on u=p.user where u=:user order by p.createdDate desc")
    String getLastUserPassword(@Param("user") User user);

    @Query("select p from Passwords p join fetch User u on u=p.user where u=:user order by p.createdDate asc")
    Passwords getLastUserPasswordObject(User user);
}
