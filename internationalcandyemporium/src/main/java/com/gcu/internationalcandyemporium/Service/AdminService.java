package com.gcu.internationalcandyemporium.Service;

import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.gcu.internationalcandyemporium.Models.Product;

@Service
public class AdminService {

  public void addProduct(@Valid Product product) {
    System.out.println("product saved!");
  }
}
