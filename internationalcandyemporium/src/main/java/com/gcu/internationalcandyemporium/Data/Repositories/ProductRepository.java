package com.gcu.internationalcandyemporium.Data.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.internationalcandyemporium.Models.ProductModel;


public interface ProductRepository extends MongoRepository<ProductModel, String> {
}