package com.gcu.internationalcandyemporium.Controllers;

import com.gcu.internationalcandyemporium.Models.ProductModel;
import com.gcu.internationalcandyemporium.Service.ProductsService;

import java.util.List; // Correct  for List
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/")
    public String home(Model model) {
        List<ProductModel> products = productsService.getAllProducts();
        // Add a logging statement to inspect the products list
        System.out.println("Products: " + products);
        model.addAttribute("products", products);
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

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
