package com.api.simple_api.entity.dto;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "output")
public class Output {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID) 
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "output_date")
  private Date outputDate;

  public Date getOutputDate() {
    return outputDate;
  }

  public void setOutputDate(Date outputDate) {
    this.outputDate = outputDate;
  }

  public Output() {}
}