package com.example.entity.dto_utils;

import java.util.Date;

public class FilteredOrder {
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private Integer customerId;

  public Integer getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  private Date fromOrderDate;

  public Date getFromOrderDate() {
    return this.fromOrderDate;
  }

  public void setFromOrderDate(Date fromOrderDate) {
    this.fromOrderDate = fromOrderDate;
  }

  private Date toOrderDate;

  public Date getToOrderDate() {
    return this.toOrderDate;
  }

  public void setToOrderDate(Date toOrderDate) {
    this.toOrderDate = toOrderDate;
  }

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  private Integer fromTotalAmount;

  public Integer getFromTotalAmount() {
    return this.fromTotalAmount;
  }

  public void setFromTotalAmount(Integer fromTotalAmount) {
    this.fromTotalAmount = fromTotalAmount;
  }

  private Integer toTotalAmount;

  public Integer getToTotalAmount() {
    return this.toTotalAmount;
  }

  public void setToTotalAmount(Integer toTotalAmount) {
    this.toTotalAmount = toTotalAmount;
  }

  private String paymentMethodName;

  public String getPaymentMethodName() {
    return this.paymentMethodName;
  }

  public void setPaymentMethod(String paymentMethodName) {
    this.paymentMethodName = paymentMethodName;
  }

  private Date fromCreateAt;

  public Date getFromCreateAt() {
    return this.fromCreateAt;
  }

  public void setFromCreateAt(Date fromCreateAt) {
    this.fromCreateAt = fromCreateAt;
  }

  private Date toCreateAt;

  public Date getToCreateAt() {
    return this.toCreateAt;
  }

  public void setToCreateAt(Date toCreateAt) {
    this.toCreateAt = toCreateAt;
  }

  public FilteredOrder() {
  }

  public FilteredOrder(Integer id, Integer customerId, Date fromOrderDate, Date toOrderDate, String status,
      Integer fromTotalAmount, Integer toTotalAmount, String paymentMethodName, Date fromCreateAt, Date toCreateAt) {
    this.id = id;
    this.customerId = customerId;
    this.fromOrderDate = fromOrderDate;
    this.toOrderDate = toOrderDate;
    this.status = status;
    this.fromTotalAmount = fromTotalAmount;
    this.toTotalAmount = toTotalAmount;
    this.paymentMethodName = paymentMethodName;
    this.fromCreateAt = fromCreateAt;
    this.toCreateAt = toCreateAt;
  }
}
