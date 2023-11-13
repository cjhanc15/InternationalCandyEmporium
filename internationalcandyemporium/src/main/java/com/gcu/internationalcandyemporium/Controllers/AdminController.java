package com.gcu.internationalcandyemporium.Controllers;

import com.gcu.internationalcandyemporium.Models.Product;
import com.gcu.internationalcandyemporium.Service.AdminService;

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
    private AdminService adminService;

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product(0, null, null, null, 0, 0));
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addProduct";
        }
        adminService.addProduct(product);
        return "redirect:/";
    }
}

