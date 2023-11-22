package com.gcu.internationalcandyemporium.Controllers;

import com.gcu.internationalcandyemporium.Data.ProductsDataService;
import com.gcu.internationalcandyemporium.Models.ProductModel;
import com.gcu.internationalcandyemporium.Service.ProductsService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductsDataService productsDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<ProductModel> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("product", new ProductModel(null, null, null, 0, 0));
        return "home";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute @Valid ProductModel product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "home";
        }
        
        productsDataService.create(product);
        return "redirect:/";
    }
    
    //future profile
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    //future cart
    @GetMapping("/cart")
    public String viewCart() {
        return "cart";
    }

    @GetMapping("/login")
    public String signIn() {
        return "login";
    }

    // @GetMapping("/logout")
    // public String logOut() {
    //     model.addAttribute("title", "Login Form");
    //     return "redirect:/login";
    // }

}

