package com.api.simple_api.entity.common;

import com.api.simple_api.config.Constance.ResponderStatus;

public class OkResponder extends Responder {
  public OkResponder(Object data) {
    super(ResponderStatus.OK, data);
  }

  public OkResponder() {
    super(ResponderStatus.OK, null);
  }
}
