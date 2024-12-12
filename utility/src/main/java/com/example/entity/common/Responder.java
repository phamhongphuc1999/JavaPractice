package com.example.entity.common;

import com.example.config.Constance.ResponderStatus;

public class Responder {
  protected ResponderStatus status;
  protected Object data;

  public Responder(ResponderStatus status, Object data) {
    this.status = status;
    this.data = data;
  }

  public ResponderStatus getStatus() {
    return this.status;
  }

  public Object getData() {
    return data;
  }

  @Override
  public boolean equals(Object entity) {
    if (entity == this)
      return true;
    if (!(entity instanceof Responder))
      return false;
    Responder res = (Responder) entity;
    return this.status == res.status && this.data.equals(res.data);
  }
}
