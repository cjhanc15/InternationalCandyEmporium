package com.gcu.internationalcandyemporium.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.internationalcandyemporium.Models.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {
  //empty for now
}