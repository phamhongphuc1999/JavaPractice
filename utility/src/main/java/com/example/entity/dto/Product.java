package com.example.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  public Supplier getSupplier() {
    return this.supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  private Long quantity;

  public Long getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
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
}
