package pl.malopolska.irregularities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import pl.malopolska.irregularities.dto.UserDto;
import pl.malopolska.irregularities.model.User;
import pl.malopolska.irregularities.services.UserService;
import pl.malopolska.irregularities.validators.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String login() {
//        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @PostMapping("/login")
    public RedirectView loginToService(UserDto userDto, HttpServletRequest request) {
        User user = userService.getUserByEmail(userDto.getEmail());
        if (user!=null) {
            if (user.checkPassword(userDto.getPassword())) {
                final HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return new RedirectView("/main/mainPage");
            } else {
                return new RedirectView("login");
            }

        } else {
            return new RedirectView("/registration");
        }
    }
}


