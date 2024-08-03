package com.api.simple_api.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Output")
public class Output {
  @Id
  @GeneratedValue(generator = "UUID")
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "outputDate")
  private Date outputDate;

  public Date getOutputDate() {
    return outputDate;
  }

  public void setOutputDate(Date outputDate) {
    this.outputDate = outputDate;
  }
}