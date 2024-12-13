package com.example.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.entity.dto_utils.NewProduct;

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
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
  @JoinColumn(name = "supplier_id", referencedColumnName = "id")
  private Supplier supplier;

  public Supplier getSupplier() {
    return this.supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  private Integer quantity;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
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

  public Product() {
  }

  public Product(NewProduct newProduct) {
    this.name = newProduct.getName();
    this.supplier.setId(newProduct.getSupplierId());
    this.quantity = newProduct.getQuantity();
    this.createAt = new Date();
  }
}
