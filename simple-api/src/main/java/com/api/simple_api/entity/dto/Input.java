package com.api.simple_api.entity.dto;

import java.sql.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "Input")
public class Input {
  @Id
  private UUID id;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date inputDate;

  public Date getInputDate() {
    return inputDate;
  }

  public void setInputDate(Date inputDate) {
    this.inputDate = inputDate;
  }
}
