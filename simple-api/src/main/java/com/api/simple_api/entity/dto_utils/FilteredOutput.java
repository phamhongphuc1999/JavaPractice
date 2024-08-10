package com.api.simple_api.entity.dto_utils;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class FilteredOutput {
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
  private Date fromOutputDate;

  public Date getFromOutputDate() {
    return fromOutputDate;
  }

  public void setFromOutputDate(Date fromOutputDate) {
    this.fromOutputDate = fromOutputDate;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date toOutputDate;

  public Date getToOutputDate() {
    return toOutputDate;
  }

  public void setToOutputDate(Date toOutputDate) {
    this.toOutputDate = toOutputDate;
  }

  private Integer fromCount;

  public Integer getFromCount() {
    return fromCount;
  }

  public void setFromCount(Integer fromCount) {
    this.fromCount = fromCount;
  }

  private Integer toCount;

  public Integer getToCount() {
    return toCount;
  }

  public void setToCount(Integer toCount) {
    this.toCount = toCount;
  }

  private Float fromOutputPrice;

  public Float getFromOutputPrice() {
    return fromOutputPrice;
  }

  public void setFromOutputPrice(Float fromOutputPrice) {
    this.fromOutputPrice = fromOutputPrice;
  }

  private Float toOutputPrice;

  public Float getToOutputPrice() {
    return toOutputPrice;
  }

  public void setToOutputPrice(Float toOutputPrice) {
    this.toOutputPrice = toOutputPrice;
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

  public FilteredOutput() {}

  public FilteredOutput(UUID id, UUID infoId, Long objectId, Long customerId, Date fromOutputDate, Date toOutputDate, Integer fromCount, Integer toCount, Float fromOutputPrice, Float toOutputPrice, String status, String objectName, String unitName, String customerName) {
    this.id = id;
    this.infoId = infoId;
    this.objectId = objectId;
    this.customerId = customerId;
    this.fromOutputDate = fromOutputDate;
    this.toOutputDate = toOutputDate;
    this.fromCount = fromCount;
    this.toCount = toCount;
    this.fromOutputPrice = fromOutputPrice;
    this.toOutputPrice = toOutputPrice;
    this.status = status;
    this.objectName = objectName;
    this.unitName = unitName;
    this.customerName = customerName;
  }
}
