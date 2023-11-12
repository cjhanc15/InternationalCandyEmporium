package com.gcu.internationalcandyemporium.Controllers;

import com.gcu.internationalcandyemporium.Models.User;
import com.gcu.internationalcandyemporium.Service.RegistrationService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String processRegistration(@ModelAttribute("user") @Valid User user, BindingResult result) {
        // Validation logic...

        if (result.hasErrors()) {
            return "registration";
        }

        // Call the registration service to handle the registration logic
        registrationService.processRegistration(user);

        return "registration-success";
    }
}

