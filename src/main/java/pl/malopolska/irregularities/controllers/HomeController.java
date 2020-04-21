package pl.malopolska.irregularities.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goHome(){
        return "index";
    }

    @GetMapping("/about")
    public String about() { return "Here you can find some details for logged users"; }

}
