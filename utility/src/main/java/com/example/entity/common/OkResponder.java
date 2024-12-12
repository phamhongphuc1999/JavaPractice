package com.example.entity.common;

import com.example.config.Constance.ResponderStatus;

public class OkResponder extends Responder {
  public OkResponder(Object data) {
    super(ResponderStatus.OK, data);
  }

  public OkResponder() {
    super(ResponderStatus.OK, null);
  }
}
