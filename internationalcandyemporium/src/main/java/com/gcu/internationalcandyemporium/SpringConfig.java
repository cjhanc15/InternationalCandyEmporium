package com.gcu.internationalcandyemporium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.internationalcandyemporium.Business.ProductsService;
import com.gcu.internationalcandyemporium.Business.ProductsServiceInterface;

@Configuration
public class SpringConfig {

    @Bean(name="productService")
    public ProductsServiceInterface getProducts(){
        return new ProductsService();
    }
}
