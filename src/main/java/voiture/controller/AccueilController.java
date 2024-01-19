package voiture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AccueilController {

    @GetMapping("/")
    public String accueil(){
        return "accueil";
    }

}