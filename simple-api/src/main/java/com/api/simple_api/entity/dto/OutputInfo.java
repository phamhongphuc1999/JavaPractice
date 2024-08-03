package com.api.simple_api.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OutputInfo")
public class OutputInfo {
  @Id
  @GeneratedValue(generator = "UUID")
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Column(name = "object_id")
  private String objectId;

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  @Column(name = "input_info_id")
  private String inputInfoId;

  public String getInputInfoId() {
    return inputInfoId;
  }

  public void setInputInfoId(String inputInfoId) {
    this.inputInfoId = inputInfoId;
  }

  @Column(name = "customer_id")
  private Integer customerId;

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  @Column(name = "count")
  private Integer count;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Column(name = "status")
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}