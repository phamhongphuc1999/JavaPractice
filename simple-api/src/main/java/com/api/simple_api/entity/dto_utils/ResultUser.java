package com.api.simple_api.entity.dto_utils;

import com.api.simple_api.entity.dto.User;

public class ResultUser extends User {
  private String roleName;

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public ResultUser(Long id, String displayName, String username, String password, Long roleId, String roleName) {
    this.setId(id);
    this.setDisplayName(displayName);
    this.setUsername(username);
    this.setPassword(password);
    this.setRoleId(roleId);
    this.roleName = roleName;
  }
}
