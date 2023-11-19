package com.gcu.internationalcandyemporium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.internationalcandyemporium.Interfaces.ProductsServiceInterface;
import com.gcu.internationalcandyemporium.Service.ProductsService;

@Configuration
public class SpringConfig {

    @Bean(name="productService")
    public ProductsServiceInterface getProducts(){
        return new ProductsService();
    }
}
