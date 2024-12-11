package com.order.entity.common;

import com.order.config.Constance.ResponderStatus;

public class OkResponder extends Responder {
  public OkResponder(Object data) {
    super(ResponderStatus.OK, data);
  }

  public OkResponder() {
    super(ResponderStatus.OK, null);
  }
}
