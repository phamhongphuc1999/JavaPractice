package com.example.entity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "import_product_detail")
public class ImportProductDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @ManyToOne
  @JoinColumn(name = "import_id")
  private ImportProduct importProduct;

  public ImportProduct getImportProduct() {
    return this.importProduct;
  }

  public void setImportProduct(ImportProduct importProduct) {
    this.importProduct = importProduct;
  }

  private Integer quantity;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
