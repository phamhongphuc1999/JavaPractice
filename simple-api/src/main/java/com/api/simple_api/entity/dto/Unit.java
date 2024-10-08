package com.api.simple_api.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unit")
public class Unit {
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
    return this.displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Unit() {}

  public Unit (String displayName) {
    this.displayName = displayName;
  }

  public Unit (Long id, String displayName) {
    this.id = id;
    this.displayName = displayName;
  }
}
