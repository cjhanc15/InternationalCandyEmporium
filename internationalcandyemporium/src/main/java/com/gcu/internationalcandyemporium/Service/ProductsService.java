package com.gcu.internationalcandyemporium.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Data.ProductsDataService;
import com.gcu.internationalcandyemporium.Data.Repositories.ProductRepository;
import com.gcu.internationalcandyemporium.Interfaces.ProductsServiceInterface;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Service
@Primary
public class ProductsService implements ProductsServiceInterface{

    @Autowired
    ProductsDataService productsDataService;
  
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> getAllProducts() {
        return productsDataService.findAll();
    }

    public void updateProduct(ProductModel product) {
        Optional<ProductModel> existingProduct = productRepository.findById(product.getId());
        try {
            if (existingProduct.isPresent()) {
                ProductModel updatedProduct = existingProduct.get();
                
                updatedProduct.setName(product.getName());
                updatedProduct.setDescription(product.getDescription());
                updatedProduct.setImageUrl(product.getImageUrl());
                updatedProduct.setPrice(product.getPrice());
                updatedProduct.setQuantity(product.getQuantity());
                productRepository.save(updatedProduct);
            } else {
                throw new Exception("Product with ID " + product.getId() + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    public void deleteProduct(ProductModel product) {
        productRepository.delete(product);
    }
}
