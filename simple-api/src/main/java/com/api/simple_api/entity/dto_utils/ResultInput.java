package com.api.simple_api.entity.dto_utils;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

public class ResultInput {
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  private UUID infoId;

  public UUID getInfoId() {
    return infoId;
  }

  public void setInfoId(UUID infoId) {
    this.infoId = infoId;
  }

  private Long objectId;

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "input_date")
  private Date inputDate;

  public Date getInputDate() {
    return inputDate;
  }

  public void setInputDate(Date inputDate) {
    this.inputDate = inputDate;
  }

  @Column(name = "count")
  private Integer count;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Column(name = "input_price")
  private Float inputPrice;

  public Float getInputPrice() {
    return inputPrice;
  }

  public void setInputPrice(Float inputPrice) {
    this.inputPrice = inputPrice;
  }

  @Column(name = "status")
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  private String objectName;

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  private String unitName;

  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  private String supplierName;

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public ResultInput(UUID id, UUID infoId, Long objectId, Date inputDate, Integer count, Float inputPrice, String status, String objectName, String unitName, String supplierName) {
    this.id = id;
    this.infoId = infoId;
    this.objectId = objectId;
    this.inputDate = inputDate;
    this.count = count;
    this.inputPrice = inputPrice;
    this.status = status;
    this.objectName = objectName;
    this.unitName = unitName;
    this.supplierName = supplierName;
  }
}
