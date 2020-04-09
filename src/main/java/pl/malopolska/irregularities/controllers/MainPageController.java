package pl.malopolska.irregularities.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {


    @GetMapping("/main/mainPage")
    public String mainPageView() {
            return "mainPage";
    }
}
