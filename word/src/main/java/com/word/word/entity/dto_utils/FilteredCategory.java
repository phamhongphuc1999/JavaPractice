package com.word.word.entity.dto_utils;

public class FilteredCategory {
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private Integer userId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public FilteredCategory(Integer id, String title, Integer userId) {
    this.id = id;
    this.title = title;
    this.userId = userId;
  }
}
