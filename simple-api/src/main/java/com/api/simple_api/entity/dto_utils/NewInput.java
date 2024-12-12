package com.api.simple_api.entity.dto_utils;

import java.util.UUID;

public class NewInput {
  private UUID objectId;

  public UUID getObjectId() {
    return objectId;
  }

  public void setObjectId(UUID objectId) {
    this.objectId = objectId;
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
}
