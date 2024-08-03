package com.api.simple_api.entity.common;

import org.springframework.http.HttpStatus;

public class BadRequestResponder extends Responder {
  public BadRequestResponder(Object data) {
    super(HttpStatus.BAD_REQUEST, data);
  }
}
