package com.word.word.entity.dto_utils;

import com.word.word.entity.dto.UserDto;

public class ResultUser extends UserDto {
  public ResultUser(Integer id, String displayName, String username, String password) {
    this.setId(id);
    this.setDisplayName(displayName);
    this.setUsername(username);
    this.setPassword(password);
  }
}
