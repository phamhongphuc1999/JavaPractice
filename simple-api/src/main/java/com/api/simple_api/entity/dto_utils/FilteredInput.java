package com.api.simple_api.entity.dto_utils;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class FilteredInput {
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
  private Date fromInputDate;

  public Date getFromInputDate() {
    return fromInputDate;
  }

  public void setFromInputDate(Date fromInputDate) {
    this.fromInputDate = fromInputDate;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date toInputDate;

  public Date getToInputDate() {
    return toInputDate;
  }

  public void setToInputDate(Date toInputDate) {
    this.toInputDate = toInputDate;
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

  private Float fromInputPrice;

  public Float getFromInputPrice() {
    return fromInputPrice;
  }

  public void setFromInputPrice(Float fromInputPrice) {
    this.fromInputPrice = fromInputPrice;
  }

  private Float toInputPrice;

  public Float getToInputPrice() {
    return toInputPrice;
  }

  public void setToInputPrice(Float toInputPrice) {
    this.toInputPrice = toInputPrice;
  }

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public FilteredInput(UUID id, UUID infoId, Long objectId, Date fromInputDate, Date toInputDate, Integer fromCount, Integer toCount, Float fromInputPrice, Float toInputPrice, String status) {
    this.id = id;
    this.infoId = infoId;
    this.objectId = objectId;
    this.fromInputDate = fromInputDate;
    this.toInputDate = toInputDate;
    this.fromCount = fromCount;
    this.toCount = toCount;
    this.fromInputPrice = fromInputPrice;
    this.toInputPrice = toInputPrice;
    this.status = status;
  }
}
