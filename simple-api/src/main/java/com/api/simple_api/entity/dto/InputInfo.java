package com.api.simple_api.entity.dto;

import java.util.UUID;

import com.api.simple_api.entity.dto_utils.NewInput;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "input_info")
public class InputInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID) 
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Column(name = "object_id")
  private Long objectId;

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  @Column(name = "input_id")
  private UUID inputId;

  public UUID getInputId() {
    return inputId;
  }

  public void setInputId(UUID inputId) {
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

  @Column(name = "status")
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public InputInfo() {}

  public InputInfo(NewInput entity, UUID inputId) {
    this.objectId = entity.getObjectId();
    this.inputId = inputId;
    this.count = entity.getCount();
    this.inputPrice = entity.getInputPrice();
    this.status = entity.getStatus();
  }
}