package com.api.simple_api.entity.common;

public class Responder {
  private String status;
  private Object data;

  public Responder(String status, Object data) {
    this.status = status;
    this.data = data;
  }

  public String getStatus() {
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

