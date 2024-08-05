package com.api.simple_api.entity.dto_utils;

public class FilteredObjectDto {
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  private Long unitId;

  public Long getUnitId() {
    return unitId;
  }

  public void setUnitId(Long unitId) {
    this.unitId = unitId;
  }

  private Long supplierId;

  public Long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Long supplierId) {
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

  public FilteredObjectDto(Long id, String displayName, Long unitId, Long supplierId, String qrCode, String barCode) {
    this.id = id;
    this.displayName = displayName;
    this.unitId = unitId;
    this.supplierId = supplierId;
    this.qrCode = qrCode;
    this.barCode = barCode;
  }
}
