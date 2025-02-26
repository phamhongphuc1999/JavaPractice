package com.word.word.entity.dto_utils;

import java.util.List;

import com.word.word.entity.dto.PairDto;

public class AllPairResult {
  private Integer categoryId;

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  private String categoryTitle;

  public String getCategoryTitle() {
    return categoryTitle;
  }

  public void setCategoryTitle(String categoryTitle) {
    this.categoryTitle = categoryTitle;
  }

  private List<PairDto> pairs;

  public List<PairDto> getPairs() {
    return pairs;
  }

  public void setPairs(List<PairDto> pairs) {
    this.pairs = pairs;
  }

  public AllPairResult(Integer categoryId, String categoryTitle, List<PairDto> pairs) {
    this.categoryId = categoryId;
    this.categoryTitle = categoryTitle;
    this.pairs = pairs;
  }
}
