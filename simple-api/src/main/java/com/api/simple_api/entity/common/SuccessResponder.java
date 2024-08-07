package com.api.simple_api.entity.common;

import com.api.simple_api.config.Constance.ResponderStatus;

public class SuccessResponder extends Responder {
  public SuccessResponder(Object data) {
    super(ResponderStatus.OK, data);
  }

  public SuccessResponder() {
    super(ResponderStatus.OK, null);
  }
}
