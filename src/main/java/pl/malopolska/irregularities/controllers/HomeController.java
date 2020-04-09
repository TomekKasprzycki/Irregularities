package pl.malopolska.irregularities.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String goHome(){
        return "Witajcie w naszej bajce";
    }

    @GetMapping("/about")
    public String about() { return "Here you can find some details for logged users"; }

}
