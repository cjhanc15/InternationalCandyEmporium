package com.gcu.internationalcandyemporium.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.internationalcandyemporium.Models.User;
import com.gcu.internationalcandyemporium.Service.RegistrationService;

@Controller
public class RegistrationController {
    
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }

        registrationService.processRegistration(user);

        return "registration-success";
    }
}




