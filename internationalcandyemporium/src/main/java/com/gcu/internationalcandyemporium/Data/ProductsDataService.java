package com.gcu.internationalcandyemporium.Data;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Data.Repositories.ProductRepository;
import com.gcu.internationalcandyemporium.Interfaces.DataAccessInterface;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Service
public class ProductsDataService implements DataAccessInterface<ProductModel> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> findAll() {
        Iterable<ProductModel> productIterable = productRepository.findAll();
        List<ProductModel> products = new ArrayList<>();
        try {
            for (ProductModel product : productIterable) {
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductModel findById(String id) {
        try {
            Optional<ProductModel> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()) {
                ProductModel product = optionalProduct.get();
                return new ProductModel(
                    product.getId(), 
                    product.getName(), 
                    product.getDescription(), 
                    product.getImageUrl(), 
                    product.getPrice(), 
                    product.getQuantity());
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    

    @Override
    public boolean create(ProductModel product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ProductModel product) {
        try {
            ProductModel updatedProduct = productRepository.save(product);
            return updatedProduct != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(ProductModel product) {
        try {
            productRepository.delete(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}