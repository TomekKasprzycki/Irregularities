package pl.malopolska.irregularities.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.UserDto;
import pl.malopolska.irregularities.services.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserValidator {

    @Autowired
    private UserService userService;

    public boolean validatePassword(UserDto userDto){
        final Pattern pattern = Pattern.compile("^([!@#$%^&*()a-zA-Z0-9]*\\d*[A-Z]+\\d*[!@#$%^&*()a-zA-Z0-9]*\\d*)+$");
        final String pass1 = userDto.getPassword();
        final String pass2 = userDto.getPassword2();
        final Matcher matcher = pattern.matcher(pass1);
        final boolean condition1 = pass1.equals(pass2);
        final boolean condition2 = matcher.matches();
        final boolean condition3 = pass1.length()>7 && pass1.length()<17;
        return condition1 && condition2 && condition3;
    }

}
