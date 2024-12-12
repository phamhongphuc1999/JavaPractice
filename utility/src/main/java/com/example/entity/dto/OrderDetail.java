package com.example.entity.dto;

import com.example.entity.dto_utils.NewOrderDetail;

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
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "order_id")
  private Integer orderId;

  public Integer getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  @Column(name = "product_id")
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

  public OrderDetail() {
  }

  public OrderDetail(NewOrderDetail newOrderDetail, Integer orderId) {
    this.orderId = orderId;
    this.productId = newOrderDetail.getProductId();
    this.quantity = newOrderDetail.getQuantity();
    this.price = newOrderDetail.getPrice();
  }
}
