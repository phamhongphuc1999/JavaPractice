package com.word.word.entity.dto_utils;

import java.io.Serializable;

public class JwtResponseUser implements Serializable {
  private final String jwtToken;

  public JwtResponseUser(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  public String getToken() {
    return this.jwtToken;
  }
}
