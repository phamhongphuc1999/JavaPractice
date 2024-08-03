package com.api.simple_api.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "InputInfo")
public class InputInfo {
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

  @Column(name = "input_id")
  private String inputId;

  public String getInputId() {
    return inputId;
  }

  public void setInputId(String inputId) {
    this.inputId = inputId;
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

  @Column(name = "output_price")
  private Float outputPrice;

  public Float getOutputPrice() {
    return outputPrice;
  }

  public void setOutputPrice(Float outputPrice) {
    this.outputPrice = outputPrice;
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
