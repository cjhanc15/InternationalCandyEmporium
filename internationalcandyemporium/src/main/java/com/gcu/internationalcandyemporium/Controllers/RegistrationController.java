package com.gcu.internationalcandyemporium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.Registration.model.User;
import com.gcu.Registration.service.RegistrationService;

@Controller
public class RegistrationController {
    
    private final RegistrationService registrationService;

    @Autowired
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

        // Call the registration service to handle the registration logic
        registrationService.processRegistration(user);

        return "registration-success";
    }
}



