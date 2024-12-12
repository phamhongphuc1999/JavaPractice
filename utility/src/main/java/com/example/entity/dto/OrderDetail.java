package com.example.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "order_id")
  private Long orderId;

  public Long getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  @Column(name = "product_id")
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
