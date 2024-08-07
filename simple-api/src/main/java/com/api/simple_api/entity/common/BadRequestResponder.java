package com.api.simple_api.entity.common;

import com.api.simple_api.config.Constance.ResponderStatus;

public class BadRequestResponder extends Responder {
  public BadRequestResponder(Object data) {
    super(ResponderStatus.FAIL, data);
  }
}
