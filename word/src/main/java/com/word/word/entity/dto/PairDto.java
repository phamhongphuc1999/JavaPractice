package com.word.word.entity.dto;

import com.word.word.entity.dto_utils.NewPair;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pair")
public class PairDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private String en;

  public String getEn() {
    return en;
  }

  public void setEn(String en) {
    this.en = en;
  }

  @Column(name = "vi", columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
  private String vi;

  public String getVi() {
    return vi;
  }

  public void setVi(String vi) {
    this.vi = vi;
  }

  @Column(name = "category_id")
  private Integer categoryId;

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public PairDto() {
  }

  public PairDto(Integer id, String en, String vi, Integer categoryId) {
    this.id = id;
    this.en = en;
    this.vi = vi;
    this.categoryId = categoryId;
  }

  public PairDto(Integer categoryId, NewPair entity) {
    this.categoryId = categoryId;
    this.en = entity.getEn();
    this.vi = entity.getVi();
  }
}
