package com.api.simple_api.entity.dto_utils;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "object")
public class NewObjectDto {
  @Column(name = "displayName")
  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Column(name = "unitId")
  private Integer unitId;

  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

  @Column(name = "supplierId")
  private Integer supplierId;

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

  @Column(name = "qrCode")
  private String qrCode;

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }

  @Column(name = "barCode")
  private String barCode;

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }
}
