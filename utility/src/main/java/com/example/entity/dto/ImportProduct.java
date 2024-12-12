package com.example.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "import_product")
public class ImportProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "input_date")
  private Date inputDate;

  public Date getInputDate() {
    return this.inputDate;
  }

  public void setInputDate(Date inputDate) {
    this.inputDate = inputDate;
  }
}
