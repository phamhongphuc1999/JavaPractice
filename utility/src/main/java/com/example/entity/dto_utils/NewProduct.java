package com.example.entity.dto_utils;

public class NewProduct {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private Integer supplierId;

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer id) {
    this.supplierId = id;
  }

  private Integer quantity;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
