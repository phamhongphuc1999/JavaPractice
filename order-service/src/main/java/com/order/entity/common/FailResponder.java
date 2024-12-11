package com.order.entity.common;

import com.order.config.Constance.ResponderStatus;

public class FailResponder extends Responder {
  public FailResponder(Object data) {
    super(ResponderStatus.FAIL, data);
  }
}
