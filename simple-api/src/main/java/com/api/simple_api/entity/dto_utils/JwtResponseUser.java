package com.api.simple_api.entity.dto_utils;

import java.io.Serializable;

public class JwtResponseUser implements Serializable {
  private static final long serialVersionUID = -8091879091924046844L;
	private final String jwtToken;

	public JwtResponseUser(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getToken() {
		return this.jwtToken;
	}
}
