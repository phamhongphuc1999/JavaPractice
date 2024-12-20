package com.kafka.producer;

import java.util.UUID;

public class SimpleObject {
  private String param1;

  public String getParam1() {
    return param1;
  }

  public void setParam1(String param1) {
    this.param1 = param1;
  }

  private Integer param2;

  public Integer getParam2() {
    return param2;
  }

  public void setParam2(Integer param2) {
    this.param2 = param2;
  }

  private UUID param3;

  public UUID getParam3() {
    return param3;
  }

  public void setParam3(UUID param3) {
    this.param3 = param3;
  }

  public SimpleObject(String param1, Integer param2, UUID param3) {
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
  }
}
