package com.api.simple_api.entity.dto_utils;

public class JwtUser {
  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public JwtUser(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
