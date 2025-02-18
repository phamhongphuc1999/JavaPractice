package com.word.word.entity.dto_utils;

public class UpdatePair {
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

  private String vi;

  public String getVi() {
    return vi;
  }

  public void setVi(String vi) {
    this.vi = vi;
  }

  public UpdatePair(Integer id, String en, String vi) {
    this.id = id;
    this.en = en;
    this.vi = vi;
  }
}
