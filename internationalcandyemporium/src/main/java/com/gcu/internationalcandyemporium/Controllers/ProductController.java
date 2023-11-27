package com.gcu.internationalcandyemporium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.internationalcandyemporium.Data.ProductsDataService;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsDataService productService;

    @GetMapping("/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) {
        ProductModel product = productService.findById(Long.parseLong(productId));
        model.addAttribute("product", product);
        return "viewProduct";
    }    

    @RequestMapping(value = "/update/{productId}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable String productId, Model model) {
        ProductModel product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product/update";  // Assuming you have a Thymeleaf or JSP page for updating a product
    }

    @PostMapping(value = "/update")
    public String processUpdateProduct(@ModelAttribute("product") ProductModel product,
                                       @RequestParam String action) {
        if ("save".equals(action)) {
            productService.update(product);
        } else if ("delete".equals(action)) {
            productService.delete(product);
        }
        return "redirect:/products/list";
    }

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable String productId) {
        productService.delete(productService.getProductById(productId));
        return "redirect:/";
    }
}
