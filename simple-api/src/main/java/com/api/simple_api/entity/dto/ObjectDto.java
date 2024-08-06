package com.api.simple_api.entity.dto;

import com.api.simple_api.entity.dto_utils.NewObjectDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "object")
public class ObjectDto {
  @Id 
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "display_name")
  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @ManyToOne
  @JoinColumn(name =  "unit_id")
  private Unit unit;

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  @Column(name = "count")
  private Integer count;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Column(name = "qr_code")
  private String qrCode;

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }

  @Column(name = "bar_code")
  private String barCode;

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  public ObjectDto() {}

  public ObjectDto(Long id, String displayName, Unit unit, Supplier supplier, Integer count, String qrCode, String barCode) {
    this.id = id;
    this.displayName = displayName;
    this.unit = unit;
    this.supplier = supplier;
    this.count = count;
    this.qrCode = qrCode;
    this.barCode = barCode;
  }

  public ObjectDto(NewObjectDto newObject) {
    this.displayName = newObject.getDisplayName();
    this.unit = new Unit(newObject.getUnitId(), newObject.getDisplayName());
    this.supplier = new Supplier();
    this.count = 0;
    this.supplier.setId(newObject.getSupplierId());
    this.qrCode = newObject.getQrCode();
    this.barCode = newObject.getBarCode();
  }
}