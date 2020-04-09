package pl.malopolska.irregularities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import pl.malopolska.irregularities.converters.InstitutionConverter;
import pl.malopolska.irregularities.converters.RoleConverter;
import pl.malopolska.irregularities.converters.UserConverter;
import pl.malopolska.irregularities.dto.InstitutionDto;
import pl.malopolska.irregularities.dto.UserDto;
import pl.malopolska.irregularities.model.Role;
import pl.malopolska.irregularities.model.User;
import pl.malopolska.irregularities.services.InstitutionService;
import pl.malopolska.irregularities.services.RoleService;
import pl.malopolska.irregularities.services.UserService;
import pl.malopolska.irregularities.validators.UserValidator;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private InstitutionConverter institutionConverter;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleConverter roleConverter;


    @GetMapping("/registration")
    public String registrationSite(Model model){

        List<InstitutionDto> institutionDtoList = institutionConverter.convertListToDto(institutionService.getAllInstitutions());
        model.addAttribute("userDto",new UserDto());
        model.addAttribute("institutionDto", new InstitutionDto());
        model.addAttribute("institutionDtoList", institutionDtoList);
        model.addAttribute("error",null);
        return "registration";
    }

    @PostMapping("/registration")
    public RedirectView userRegistration(UserDto userDto, Model model) {

        Role role = roleService.getRoleById(5L);
        userDto.setRoleDto(roleConverter.convertToDto(role));
        userDto.setActive(false);
        if (userService.checkUser(userDto)) {
            if (userValidator.validatePassword(userDto)) {
                User user = userConverter.convertFromDto(userDto);
                User savedUser = userService.saveUser(user);
                return new RedirectView("/login");
            }
            String error = "Hasła nie są identyczne lub nie pasują do wzoru!";
            model.addAttribute("error",error);
            return new RedirectView("/registration");
        }
        String error = "Email jest zajęty!";
        model.addAttribute("error",error);
        return new RedirectView("/registration");
    }
}
