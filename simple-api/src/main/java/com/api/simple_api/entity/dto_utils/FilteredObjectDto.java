package com.api.simple_api.entity.dto_utils;

import java.util.UUID;

public class FilteredObjectDto {
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  private Integer unitId;

  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

  private Integer supplierId;

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

  private String qrCode;

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }

  private String barCode;

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  public FilteredObjectDto(UUID id, String displayName, Integer unitId, Integer supplierId, String qrCode,
      String barCode) {
    this.id = id;
    this.displayName = displayName;
    this.unitId = unitId;
    this.supplierId = supplierId;
    this.qrCode = qrCode;
    this.barCode = barCode;
  }
}
