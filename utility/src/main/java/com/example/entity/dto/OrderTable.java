package com.example.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.config.Constance;
import com.example.entity.dto_utils.NewOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class OrderTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "customer_id")
  private Integer customerId;

  public Integer getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "order_date")
  private Date orderDate;

  public Date getOrderDate() {
    return this.orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  @Column(name = "status")
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Column(name = "total_amount")
  private Integer totalAmount;

  public Integer getTotalAmount() {
    return this.totalAmount;
  }

  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  @ManyToOne
  @JoinColumn(name = "payment_method_id")
  private PaymentMethod paymentMethod;

  public PaymentMethod getPaymentMethod() {
    return this.paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "created_at")
  private Date createAt;

  public Date getCreateAt() {
    return this.createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "updated_at")
  private Date updateAt;

  public Date getUpdateAt() {
    return this.updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }

  public OrderTable() {
  }

  public OrderTable(NewOrder newOrder) {
    this.customerId = newOrder.getCustomerId();
    this.orderDate = newOrder.getOrderDate();
    this.status = Constance.OrderStatus.PENDING.toString();
    this.totalAmount = newOrder.getOrderDetails().size();
    this.paymentMethod = new PaymentMethod();
    this.paymentMethod.setId(newOrder.getPaymentMethodId());
    this.createAt = new Date();
    this.updateAt = this.createAt;
  }
}
