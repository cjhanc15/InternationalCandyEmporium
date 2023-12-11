package com.gcu.internationalcandyemporium.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.internationalcandyemporium.Models.ProductModel;

@RestController
@RequestMapping("/service")
public class RestAPI {
  @Autowired
  ProductsBusinessService productsBusinessService;

  @GetMapping(path="/products")
  public ResponseEntity<?> getProducts() {
    try {
      List<ProductModel> products = productsBusinessService.getAllProducts();
      if(products.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      else return new ResponseEntity<>(products, HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path="/products/{id}")
  public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
      try {
          Long longId = Long.parseLong(id); // Convert String to Long
          Optional<ProductModel> productOptional = productsBusinessService.getProductById(longId);
          
          if(!productOptional.isPresent()) {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          } else {
              return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
          }
      } catch (NumberFormatException e) {
          return new ResponseEntity<>("Invalid ID format", HttpStatus.BAD_REQUEST);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }  
  

}
