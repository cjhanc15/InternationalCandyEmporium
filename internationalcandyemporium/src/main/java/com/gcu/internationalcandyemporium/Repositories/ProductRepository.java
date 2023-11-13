package com.gcu.internationalcandyemporium.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gcu.internationalcandyemporium.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  //future db implementation
}
