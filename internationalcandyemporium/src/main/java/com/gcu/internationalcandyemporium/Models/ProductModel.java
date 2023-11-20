package com.gcu.internationalcandyemporium.Models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductModel {
  private long id;

  @NotBlank(message = "Name field is required")
  private String name;

  @Size(max = 1000, message = "Description field too long")
  private String description;

  @NotBlank(message = "Must have image")
  private String imageUrl;

  @Min(value = 0, message = "Price must be positive")
  private Double price;

  @Min(value = 0, message = "Quantity must be positive")
  private Integer quantity;

    public ProductModel() {
      
    }

    // Constructor for creating new products (ID not included)
    public ProductModel(String name, String description, String imageUrl, double price, int quantity) {
      this.name = name;
      this.description = description;
      this.imageUrl = imageUrl;
      this.price = price;
      this.quantity = quantity;
  }

  // Constructor for retrieving existing products (includes ID)
  public ProductModel(Long id, String name, String description, String imageUrl, double price, int quantity) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.imageUrl = imageUrl;
      this.price = price;
      this.quantity = quantity;
  }
  public Long getId() {
    return id;
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
  
  public Double getPrice() {
    return price;
  }
  
  public void setPrice(Double price) {
    this.price = price;
  }
  
  public Integer getQuantity() {
    return quantity;
  }
  
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
      return "Product{" +
             ", name='" + name + '\'' +
             ", description='" + description + '\'' +
             ", imageUrl='" + imageUrl + '\'' +
             ", price=" + price +
             ", quantity=" + quantity +
             '}';
  }
}
