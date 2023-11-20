package com.gcu.internationalcandyemporium.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Data.ProductsDataService;
import com.gcu.internationalcandyemporium.Interfaces.ProductsServiceInterface;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Service
@Primary
public class ProductsService implements ProductsServiceInterface{

    @Autowired
    ProductsDataService productsDataService;

    @Override
    public List<ProductModel> getAllProducts() {
        return productsDataService.findAll();
    }
}
