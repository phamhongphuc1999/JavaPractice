package com.api.simple_api.entity.dto_utils;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class ResultOutput {
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

  private Long customerId;

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date outputDate;

  public Date getOutputDate() {
    return outputDate;
  }

  public void setOutputDate(Date outputDate) {
    this.outputDate = outputDate;
  }

  private Integer count;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  private Float outputPrice;

  public Float getOutputPrice() {
    return outputPrice;
  }

  public void setOutputPrice(Float outputPrice) {
    this.outputPrice = outputPrice;
  }

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

  public String customerName;

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  private String supplierName;

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public ResultOutput(UUID id, UUID infoId, Long objectId, Long customerId, Date outputDate, Integer count, Float outputPrice, String status, String objectName, String unitName, String customerName, String supplierName) {
    this.id = id;
    this.infoId = infoId;
    this.objectId = objectId;
    this.customerId = customerId;
    this.outputDate = outputDate;
    this.count = count;
    this.outputPrice = outputPrice;
    this.status = status;
    this.objectName = objectName;
    this.unitName = unitName;
    this.customerName = customerName;
    this.supplierName = supplierName;
  }
}
