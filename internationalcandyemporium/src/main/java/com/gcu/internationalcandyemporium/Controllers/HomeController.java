package com.gcu.internationalcandyemporium.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "home";
    }

    //future profile
    @GetMapping("/profile")
    public ModelAndView profile() {
        // Logic to handle profile view
        ModelAndView modelAndView = new ModelAndView("profile");
        return modelAndView;
    }

    //future cart
    @GetMapping("/cart")
    public ModelAndView viewCart() {
        // Logic to handle cart view
        ModelAndView modelAndView = new ModelAndView("cart");
        return modelAndView;
    }

    @GetMapping("/login")
    public String signIn() {
        return "login";
    }

    //future logout
    @GetMapping("/logout")
    public ModelAndView logOut() {
        // Logic to handle logout
        ModelAndView modelAndView = new ModelAndView("logout");
        return modelAndView;
    }
}
