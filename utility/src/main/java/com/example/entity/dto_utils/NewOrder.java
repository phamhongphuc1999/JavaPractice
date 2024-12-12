package com.example.entity.dto_utils;

import java.util.Date;
import java.util.List;

public class NewOrder {
  private Long customerId;

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
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

  private Long paymentMethodId;

  public Long getPaymentMethodId() {
    return this.paymentMethodId;
  }

  public void setPaymentMethod(Long paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }
}
