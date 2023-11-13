package com.gcu.internationalcandyemporium.Business;

import org.springframework.stereotype.Service;
import java.util.List;
import com.gcu.internationalcandyemporium.Models.Product;

@Service
public interface ProductsServiceInterface {

    public List<Product> getAllProducts();
}
