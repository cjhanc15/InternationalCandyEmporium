package com.gcu.internationalcandyemporium.Models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Product {

  private int id;

  @NotBlank(message = "Name field is required")
  private String name;

  @Size(max = 1000, message = "Description field too long")
  private String description;

  private String imageUrl;

  @Min(value = 0, message = "Price must be positive")
  private double price;

  @Min(value = 0, message = "Quantity must be non-negative")
  private int quantity;

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
}

  public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public int getQuantity() {
    return quantity;
  }
  
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
