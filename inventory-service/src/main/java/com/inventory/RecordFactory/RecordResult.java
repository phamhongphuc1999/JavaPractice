package com.inventory.RecordFactory;

import com.example.config.Constance.OrderStatus;

public class RecordResult {
  private Integer customerId;

  public Integer getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  private Integer orderId;

  public Integer getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  private OrderStatus status;

  public OrderStatus getOrderStatus() {
    return this.status;
  }

  public void setOrderStatus(OrderStatus status) {
    this.status = status;
  }

  public RecordResult(Integer customerId, Integer orderId, OrderStatus status) {
    this.customerId = customerId;
    this.orderId = orderId;
    this.status = status;
  }
}
