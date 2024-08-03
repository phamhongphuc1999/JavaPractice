package com.api.simple_api.entity.common;

import org.springframework.http.HttpStatus;

public class SuccessResponder extends Responder {
  public SuccessResponder(Object data) {
    super(HttpStatus.OK, data);
  }

  public SuccessResponder() {
    super(HttpStatus.OK, null);
  }
}
