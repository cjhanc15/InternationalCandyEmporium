package com.gcu.internationalcandyemporium.Data.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.internationalcandyemporium.Models.ProductModel;


public interface ProductRepository extends CrudRepository<ProductModel, Long> {
      List<ProductModel> findAll();

}