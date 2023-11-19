package com.gcu.internationalcandyemporium.Interfaces;

import org.springframework.stereotype.Service;
import java.util.List;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Service
public interface ProductsServiceInterface {

    public List<ProductModel> getAllProducts();
}
