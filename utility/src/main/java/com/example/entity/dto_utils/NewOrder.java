package com.example.entity.dto_utils;

import java.util.Date;
import java.util.List;

public class NewOrder {
  private Integer customerId;

  public Integer getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  private Date orderDate;

  public Date getOrderDate() {
    return this.orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  private List<NewOrderDetail> orderDetails;

  public List<NewOrderDetail> getOrderDetails() {
    return this.orderDetails;
  }

  public void setTotalAmount(List<NewOrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  private Integer paymentMethodId;

  public Integer getPaymentMethodId() {
    return this.paymentMethodId;
  }

  public void setPaymentMethod(Integer paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }
}
