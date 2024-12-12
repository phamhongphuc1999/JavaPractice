package com.example.entity.common;

import com.example.config.Constance.ResponderStatus;

public class FailResponder extends Responder {
  public FailResponder(Object data) {
    super(ResponderStatus.FAIL, data);
  }
}
