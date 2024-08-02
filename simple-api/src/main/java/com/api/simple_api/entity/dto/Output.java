package com.api.simple_api.entity.dto;

import java.sql.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "Output")
public class Output {
  @Id
  private UUID id;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date outputDate;

  public Date getOutputDate() {
    return outputDate;
  }

  public void setOutputDate(Date outputDate) {
    this.outputDate = outputDate;
  }
}
