package com.api.simple_api.entity.dto_utils;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FilteredCustomer {
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
  private Date fromContractDate;

  public Date getFromContractDate() {
    return fromContractDate;
  }

  public void setFromContractDate(Date fromContractDate) {
    this.fromContractDate = fromContractDate;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date toContractDate;

  public Date getToContractDate() {
    return toContractDate;
  }

  public void setToContractDate(Date toContractDate) {
    this.toContractDate = toContractDate;
  }

  public FilteredCustomer(Long id, String displayName, String address, String phone, String email, String moreInfo, Date fromContractDate, Date toContractDate) {
    this.id = id;
    this.displayName = displayName;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.moreInfo = moreInfo;
    this.fromContractDate = fromContractDate;
    this.toContractDate = toContractDate;
  }
}
