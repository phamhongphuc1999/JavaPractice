package com.api.simple_api.entity.dto_utils;

import java.util.UUID;

public class NewOutput {
  private UUID objectId;

  public UUID getObjectId() {
    return objectId;
  }

  public void setObjectId(UUID objectId) {
    this.objectId = objectId;
  }

  private Integer customerId;

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
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
}
