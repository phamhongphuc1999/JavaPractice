package com.api.simple_api.entity.dto_utils;

public class NewUser {
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

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  private Long roleId;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public NewUser(String displayName, String username, String password, Long roleId) {
    this.displayName = displayName;
    this.username = username;
    this.password = password;
    this.roleId = roleId;
  }
}
