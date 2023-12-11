package com.gcu.internationalcandyemporium.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Data.Repositories.ProductRepository;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Service
public class ProductsBusinessService {
   @Autowired
  private ProductRepository productRepository;

  public ProductsBusinessService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ProductModel> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<ProductModel> getProductById(Long id) {
    return productRepository.findById(id);
  }
}