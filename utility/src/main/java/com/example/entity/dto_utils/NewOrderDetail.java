package com.example.entity.dto_utils;

public class NewOrderDetail {
  private Integer productId;

  public Integer getProductId() {
    return this.productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  private Integer quantity;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
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
