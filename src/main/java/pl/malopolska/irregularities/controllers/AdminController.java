package pl.malopolska.irregularities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malopolska.irregularities.converters.UserConverter;
import pl.malopolska.irregularities.dto.UserDto;
import pl.malopolska.irregularities.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping("/userPreview")
    public String startPanel(Model model){

        List<UserDto> activeUsers = userConverter.convertToDto(userService.getActiveUsers());
        List<UserDto> unActiveUsers = userConverter.convertToDto(userService.getUnActiveUsers());

        model.addAttribute("activeUsers", activeUsers);
        model.addAttribute("unActiveUsers",unActiveUsers);
        return "adminPanel";
    }



}
