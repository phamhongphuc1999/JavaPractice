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
@Table(name = "input")
public class Input {
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
  @Column(name = "input_date")
  private Date inputDate;

  public Date getInputDate() {
    return inputDate;
  }

  public void setInputDate(Date inputDate) {
    this.inputDate = inputDate;
  }

  public Input() {}

  public Input(Date inputDate) {
    this.inputDate = inputDate;
  }

  public Input(UUID id, Date inputDate) {
    this.id = id;
    this.inputDate = inputDate;
  }
}