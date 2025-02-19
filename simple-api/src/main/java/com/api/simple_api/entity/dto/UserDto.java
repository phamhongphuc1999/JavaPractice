package com.api.simple_api.entity.dto;

import com.api.simple_api.entity.dto_utils.NewUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "display_name")
  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Column(name = "username")
  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name = "password")
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "role_id")
  private Integer roleId;

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public UserDto() {
  }

  public UserDto(NewUser entity) {
    this.displayName = entity.getDisplayName();
    this.username = entity.getUsername();
    this.password = entity.getPassword();
    this.roleId = entity.getRoleId();
  }

  public UserDto(Integer id, String displayName, String username, String password, Integer roleId) {
    this.id = id;
    this.displayName = displayName;
    this.username = username;
    this.password = password;
    this.roleId = roleId;
  }
}