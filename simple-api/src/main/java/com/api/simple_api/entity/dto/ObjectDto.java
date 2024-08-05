package com.api.simple_api.entity.dto;

import com.api.simple_api.entity.dto_utils.NewObjectDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Object")
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

  public ObjectDto(Long id, String displayName, Integer unitId, Integer supplierId, String qrCode, String barCode) {
    this.id = id;
    this.displayName = displayName;
    this.unitId = unitId;
    this.supplierId = supplierId;
    this.qrCode = qrCode;
    this.barCode = barCode;
  }

  public ObjectDto(NewObjectDto newObject) {
    this.displayName = newObject.getDisplayName();
    this.unitId = newObject.getUnitId();
    this.supplierId = newObject.getSupplierId();
    this.qrCode = newObject.getQrCode();
    this.barCode = newObject.getBarCode();
  }
}