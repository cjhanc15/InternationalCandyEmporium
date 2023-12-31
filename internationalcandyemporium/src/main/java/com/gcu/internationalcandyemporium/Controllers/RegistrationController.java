package com.gcu.internationalcandyemporium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.internationalcandyemporium.Interfaces.RegistrationServiceInterface;
import com.gcu.internationalcandyemporium.Models.UserModel;

@Controller
public class RegistrationController {
    
    private final RegistrationServiceInterface registrationService;

    public RegistrationController(RegistrationServiceInterface registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") UserModel user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }

        if(registrationService.processRegistration(user) == true) return "redirect:/login/";
        else return "registration";

    }
}




