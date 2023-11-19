package com.gcu.internationalcandyemporium.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Interfaces.ProductsServiceInterface;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Service
@Primary
public class ProductsService implements ProductsServiceInterface{

    @Override
    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<ProductModel>();

        products.add(new ProductModel("Snickers", "Chocolate bar with caramel and peanuts", "https://i.ebayimg.com/images/g/RHkAAOSwdEZgxkh0/s-l1200.webp", 1.99, 100));
        products.add(new ProductModel("Buttercup", "Peanut butter and chocolate cup", "buttercup_image_url", 2.49, 80));
        products.add(new ProductModel("CandyCorn", "Tri-colored halloween candy", "https://m.media-amazon.com/images/I/71OIhyRTp7L.jpg", 0.99, 150));        

        return products;
    }
}
