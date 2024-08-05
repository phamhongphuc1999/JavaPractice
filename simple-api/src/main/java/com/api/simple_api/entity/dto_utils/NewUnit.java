package com.api.simple_api.entity.dto_utils;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "unit")
public class NewUnit {
  @Column(name = "display_name")
  private String displayName;

  public String getDisplayName() {
    return this.displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
}
