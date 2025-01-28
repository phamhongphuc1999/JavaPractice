package com.word.word.entity.commons;

import java.util.Date;

public class TokenEntity {
  private String token;

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  private Date expireDate;

  public Date getExpireDate() {
    return this.expireDate;
  }

  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }

  public TokenEntity(String token, Date expireDate) {
    this.token = token;
    this.expireDate = expireDate;
  }
}
