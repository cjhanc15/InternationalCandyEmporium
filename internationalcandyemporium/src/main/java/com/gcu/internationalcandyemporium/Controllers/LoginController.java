package com.gcu.internationalcandyemporium.Controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.internationalcandyemporium.Models.User;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @GetMapping("/")
    public String display(Model model){
        //Gives login page a title and puts the information from info box into an object
        model.addAttribute("title", "Login ");
        model.addAttribute("userModel", new User());
        return "login";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid User user, BindingResult bindingResult, Model model){
        //Checks to see if Username and Password are being taken
        System.out.println(String.format("Form with Username of %s and Password of %s", user.getUsername(), user.getPassword()));
        //check for validation errors
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login ");
            return "login";
        }

        //return to homepage
        return "home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
