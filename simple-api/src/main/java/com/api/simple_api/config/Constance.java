package com.api.simple_api.config;

public class Constance {
  public static enum ResponderStatus {
    OK {
      @Override
      public String toString() {
        return "ok";
      }
    },
    FAIL {
      @Override
      public String toString() {
        return "fail";
      }
    }
  }
}
