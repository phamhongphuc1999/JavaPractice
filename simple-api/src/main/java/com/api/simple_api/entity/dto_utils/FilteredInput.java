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

  private Integer count;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  private Float inputPrice;

  public Float getInputPrice() {
    return inputPrice;
  }

  public void setInputPrice(Float inputPrice) {
    this.inputPrice = inputPrice;
  }

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public FilteredInput(UUID id, UUID infoId, Long objectId, Date fromInputDate, Date toInputDate, Integer count, Float inputPrice, String status) {
    this.id = id;
    this.infoId = infoId;
    this.objectId = objectId;
    this.fromInputDate = fromInputDate;
    this.toInputDate = toInputDate;
    this.count = count;
    this.inputPrice = inputPrice;
    this.status = status;
  }
}
