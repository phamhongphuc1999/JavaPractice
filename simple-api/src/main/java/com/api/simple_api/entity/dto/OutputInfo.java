package com.api.simple_api.entity.dto;

import java.util.UUID;

import com.api.simple_api.entity.dto_utils.NewOutput;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "output_info")
public class OutputInfo {
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

  @Column(name = "output_id")
  private UUID outputId;

  public UUID getOutputId() {
    return outputId;
  }

  public void setOutputId(UUID outputId) {
    this.outputId = outputId;
  }

  @Column(name = "customer_id")
  private Long customerId;

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
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

  public OutputInfo() {}

  public OutputInfo(NewOutput entity, UUID outputId) {
    this.objectId = entity.getObjectId();
    this.outputId = outputId;
    this.customerId = entity.getCustomerId();
    this.count = entity.getCount();
    this.outputPrice = entity.getOutputPrice();
    this.status = entity.getStatus(); 
  }
}