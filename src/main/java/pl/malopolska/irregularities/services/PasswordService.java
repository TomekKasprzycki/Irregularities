package pl.malopolska.irregularities.services;

import org.hibernate.TransientObjectException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.Passwords;
import pl.malopolska.irregularities.model.User;
import pl.malopolska.irregularities.repository.PasswordRepo;
import pl.malopolska.irregularities.repository.UserRepo;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class PasswordService {

    private PasswordRepo passwordRepo;
    private UserRepo userRepo;

    private PasswordService(PasswordRepo passwordRepo, UserRepo userRepo){
        this.passwordRepo = passwordRepo;
        this.userRepo = userRepo;
    }

    public void setPassword(User user, String unHashedPassword){

        int numberOfPasswords = passwordRepo.countAllByUser(user);

        if(numberOfPasswords<12){
            String hashedPassword = BCrypt.hashpw(unHashedPassword, BCrypt.gensalt());
            Passwords password = new Passwords();
            password.setPassword(hashedPassword);
            password.setCreatedDate(LocalDate.now());
            password.setUser(user);
            passwordRepo.save(password);
        } else {
            Passwords password = passwordRepo.getFirstUserPassword(user);
            String hashedPassword = BCrypt.hashpw(unHashedPassword, BCrypt.gensalt());
            password.setPassword(hashedPassword);
            password.setCreatedDate(LocalDate.now());
            passwordRepo.save(password);
        }

    }

    public Boolean checkPassword(User user, String unHashedPassword){
        String password = passwordRepo.getLastUserPassword(user);
        return BCrypt.checkpw(unHashedPassword,password);
    }
    
    public Boolean shouldBeChanged(User user){
        Passwords lastPassword = passwordRepo.getLastUserPasswordObject(user);
        final LocalDate expirationDate = lastPassword.getCreatedDate().plus(Period.ofDays(30));
        if(LocalDate.now().isAfter(expirationDate)){
            return true;
        } else {
            return false;
        }
    }
}
