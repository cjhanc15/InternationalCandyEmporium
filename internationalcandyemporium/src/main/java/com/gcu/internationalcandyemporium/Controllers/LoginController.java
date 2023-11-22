package com.gcu.internationalcandyemporium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.internationalcandyemporium.Interfaces.ProductsServiceInterface;
import com.gcu.internationalcandyemporium.Models.UserModel;
import com.gcu.internationalcandyemporium.Service.SecurityService;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ProductsServiceInterface service;
    @Autowired
    private SecurityService security;
    
    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("title", "Login Form");
        model.addAttribute("user", new UserModel());
        return "login";
    }

    @PostMapping("/processLogin")
    public String processLogin(@ModelAttribute("user") UserModel user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }
        
        if (!security.authenticate(user.getUsername(), user.getPassword())) {
            model.addAttribute("title", "Login Form");
            model.addAttribute("loginError", "Invalid username or password");
            return "login";
        }

        return "redirect:/";
    }

}
