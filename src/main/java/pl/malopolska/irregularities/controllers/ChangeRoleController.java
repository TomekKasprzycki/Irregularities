package pl.malopolska.irregularities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import pl.malopolska.irregularities.model.User;
import pl.malopolska.irregularities.services.UserService;

@Controller
@RequestMapping(value = "/admin")
public class ChangeRoleController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/activate/{id}")
    public RedirectView activateUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        user.setActive(true);
        userService.saveUser(user);
        return new RedirectView("/admin/userPreview");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deactivate/{id}")
    public RedirectView deActivateUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        user.setActive(false);
        userService.saveUser(user);
        return new RedirectView("/admin/userPreview");
    }

}
