package com.example.entity.dto_utils;

public class SavedNewOrder extends NewOrder {
  private Integer orderId;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public SavedNewOrder(Integer orderId, NewOrder newOrder) {
    this.orderId = orderId;
    this.setCustomerId(newOrder.getCustomerId());
    this.setOrderDate(newOrder.getOrderDate());
    this.setOrderDetail(newOrder.getOrderDetails());
    this.setPaymentMethodId(newOrder.getPaymentMethodId());
  }
}
