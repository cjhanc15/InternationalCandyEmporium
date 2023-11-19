package com.gcu.internationalcandyemporium.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
        //Gives login page a title and puts the information from info box into an object
        model.addAttribute("title", "Login Form");
        model.addAttribute("user", new UserModel());
        return "login";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid UserModel user, BindingResult bindingResult, Model model){
        //Attempts to verify username and their password
        security.authenticate(null, null);
        
        //Checks to see if Username and Password are being taken
        System.out.println(String.format("Form with Username of %s and Password of %s", user.getUsername(), user.getPassword()));
        
        //check for validation errors
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login Form");
            return "login";
        }

        model.addAttribute("title", "My Products");
        model.addAttribute("products", service.getAllProducts());

        //return to homepage
        return "redirect:/";
    }
}
