package com.api.simple_api.entity.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "UserRole")
public class UserRole {
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
}
