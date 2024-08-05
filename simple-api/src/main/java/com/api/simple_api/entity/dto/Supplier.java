package com.api.simple_api.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.simple_api.entity.dto_utils.NewSupplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "display_name")
  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Column(name = "address")
  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Column(name = "phone")
  private String phone;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Column(name = "email")
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "more_info")
  private String moreInfo;

  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "contract_date")
  private Date contractDate;

  public Date getContractDate() {
    return this.contractDate;
  }

  public void setContractDate(Date contractDate) {
    this.contractDate = contractDate;
  }

  public Supplier() {}

  public Supplier(String displayName, String address, String phone, String email, String moreInfo, Date contractDate) {
    this.displayName = displayName;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.moreInfo = moreInfo;
    this.contractDate = contractDate;
  }

  public Supplier(NewSupplier newSupplier) {
    this.displayName = newSupplier.getDisplayName();
    this.address = newSupplier.getAddress();
    this.phone = newSupplier.getPhone();
    this.email = newSupplier.getEmail();
    this.moreInfo = newSupplier.getMoreInfo();
    this.contractDate = new Date();
  }
}