package com.example.entity.dto_utils;

import java.util.Date;
import java.util.List;

public class NewOrder {
  protected Integer customerId;

  public Integer getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  protected Date orderDate;

  public Date getOrderDate() {
    return this.orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  protected List<NewOrderDetail> orderDetails;

  public List<NewOrderDetail> getOrderDetails() {
    return this.orderDetails;
  }

  public void setOrderDetail(List<NewOrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  protected Integer paymentMethodId;

  public Integer getPaymentMethodId() {
    return this.paymentMethodId;
  }

  public void setPaymentMethodId(Integer paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }
}
