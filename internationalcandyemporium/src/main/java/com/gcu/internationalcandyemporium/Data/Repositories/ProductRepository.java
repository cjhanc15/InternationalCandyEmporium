package com.gcu.internationalcandyemporium.Data.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.internationalcandyemporium.Models.ProductModel;


public interface ProductRepository extends CrudRepository<ProductModel, Long> {
}