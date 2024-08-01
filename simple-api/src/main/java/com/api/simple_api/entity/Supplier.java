package com.api.simple_api.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "Supplier")
public class Supplier {
  @Id 
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  private String phone;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String moreInfo;

  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date contractDate;

  public Date getContractDate() {
    return this.contractDate;
  }

  public void setContractDate(Date contractDate) {
    this.contractDate = contractDate;
  }
}
