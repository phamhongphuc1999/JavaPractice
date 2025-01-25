package com.word.word.entity.dto_utils;

import java.util.List;

public class NewCategory {
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private List<NewPair> pairs;

  public List<NewPair> getPairs() {
    return pairs;
  }

  public void setPairs(List<NewPair> pairs) {
    this.pairs = pairs;
  }

  public NewCategory() {
  }

  public NewCategory(String title, List<NewPair> pairs) {
    this.title = title;
    this.pairs = pairs;
  }
}
