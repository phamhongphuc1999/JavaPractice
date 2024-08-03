package com.api.simple_api.entity.common;

import org.springframework.http.HttpStatus;

public class Responder {
  protected HttpStatus status;
  protected Object data;

  public Responder(HttpStatus status, Object data) {
    this.status = status;
    this.data = data;
  }

  public HttpStatus getStatus() {
    return this.status;
  }

  public Object getData() {
    return data;
  }

  @Override
  public boolean equals(Object entity) {
    if (entity == this) return true;
    if (!(entity instanceof Responder)) return false;
    Responder res = (Responder) entity;
    return this.status == res.status && this.data.equals(res.data);
  }
}

