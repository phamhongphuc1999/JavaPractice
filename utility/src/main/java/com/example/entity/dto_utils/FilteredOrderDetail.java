package com.example.entity.dto_utils;

public class FilteredOrderDetail {
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private Integer orderId;

  public Integer getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  private Integer productId;

  public Integer getProductId() {
    return this.productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  private Integer fromQuantity;

  public Integer getFromQuantity() {
    return this.fromQuantity;
  }

  public void setFromQuantity(Integer fromQuantity) {
    this.fromQuantity = fromQuantity;
  }

  private Integer toQuantity;

  public Integer getToQuantity() {
    return this.toQuantity;
  }

  public void setToQuantity(Integer toQuantity) {
    this.toQuantity = toQuantity;
  }

  private Float fromPrice;

  public Float getFromPrice() {
    return this.fromPrice;
  }

  public void setFromPrice(Float fromPrice) {
    this.fromPrice = fromPrice;
  }

  private Float toPrice;

  public Float getToPrice() {
    return this.toPrice;
  }

  public void setToPrice(Float toPrice) {
    this.toPrice = toPrice;
  }

  public FilteredOrderDetail() {
  }

  public FilteredOrderDetail(Integer id, Integer orderId, Integer productId, Integer fromQuantity, Integer toQuantity,
      Float fromPrice, Float toPrice) {
    this.id = id;
    this.orderId = orderId;
    this.productId = productId;
    this.fromQuantity = fromQuantity;
    this.toQuantity = toQuantity;
    this.fromPrice = fromPrice;
    this.toPrice = toPrice;
  }
}
