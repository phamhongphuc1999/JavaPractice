package com.example.entity.dto_utils;

public class NewOrderDetail {
  private Long productId;

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  private Long quantity;

  public Long getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  private Float price;

  public Float getPrice() {
    return this.price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }
}
