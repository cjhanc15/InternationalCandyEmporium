package com.gcu.internationalcandyemporium.Controllers;

import com.gcu.internationalcandyemporium.Data.ProductsDataService;
import com.gcu.internationalcandyemporium.Models.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductsDataService productsDataService;

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new ProductModel(null, null, null, 0, 0));
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute @Valid ProductModel product, BindingResult result, Model model) {
        System.out.println("Received product: " + product);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "addProduct";
        }
        
        productsDataService.create(product);
        return "redirect:/";
    }
}
