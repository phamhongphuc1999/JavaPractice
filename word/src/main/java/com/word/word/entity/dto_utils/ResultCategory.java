package com.word.word.entity.dto_utils;

import com.word.word.entity.dto.CategoryDto;

public class ResultCategory extends CategoryDto {
  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public ResultCategory(Integer id, String title, Integer userId, String displayName, String username) {
    this.setId(id);
    this.setTitle(title);
    this.setUserId(userId);
    this.setDisplayName(displayName);
    this.setUsername(username);
  }
}
