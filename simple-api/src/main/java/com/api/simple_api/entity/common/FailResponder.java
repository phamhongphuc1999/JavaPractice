package com.api.simple_api.entity.common;

import com.api.simple_api.config.Constance.ResponderStatus;

public class FailResponder extends Responder {
  public FailResponder(Object data) {
    super(ResponderStatus.FAIL, data);
  }
}
