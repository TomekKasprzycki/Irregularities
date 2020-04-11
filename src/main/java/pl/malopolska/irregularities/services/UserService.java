package pl.malopolska.irregularities.services;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.UserDto;
import pl.malopolska.irregularities.model.User;
import pl.malopolska.irregularities.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    private UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User getUserByEmail(String login){
        return userRepo.findUserByEmail(login);
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public boolean checkUser(UserDto userDto){
        String email = userDto.getEmail();
        Long numberOfUsers = userRepo.countUserByEmail(email);
        return numberOfUsers==0;
    }

    public User getUserById(Long creatorId) {return userRepo.findUserById(creatorId);}


    public List<User> getActiveUsers() {
        return userRepo.findAllActive();
    }

    public List<User> getUnActiveUsers() {
        return userRepo.findAllUnActive();
    }

    public User setActiveTrue(Long id) {
        return userRepo.setUserActive(id);
    }
}
