package com.example.entity.dto_utils;

import java.util.Date;

public class FilteredProduct {
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private Integer supplierId;

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer id) {
    this.supplierId = id;
  }

  private Integer quantity;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
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

  private Date fromUpdateAt;

  public Date getFromUpdateAt() {
    return this.fromUpdateAt;
  }

  public void setFromUpdateAt(Date fromUpdateAt) {
    this.fromUpdateAt = fromUpdateAt;
  }

  private Date toUpdateAt;

  public Date getToUpdateAt() {
    return this.toUpdateAt;
  }

  public void setToUpdateAt(Date toUpdateAt) {
    this.toUpdateAt = toUpdateAt;
  }

  public FilteredProduct(Integer id, String name, Integer supplierId, Integer quantity, Date fromCreateAt,
      Date toCreateAt, Date fromUpdateAt, Date toUpdateAt) {
    this.id = id;
    this.name = name;
    this.supplierId = supplierId;
    this.quantity = quantity;
    this.fromCreateAt = fromCreateAt;
    this.toCreateAt = toCreateAt;
    this.fromUpdateAt = fromUpdateAt;
    this.toUpdateAt = toUpdateAt;
  }
}
