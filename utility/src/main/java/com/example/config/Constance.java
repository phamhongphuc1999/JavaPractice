package com.example.config;

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

  public static enum OrderStatus {
    PENDING {
      @Override
      public String toString() {
        return "PENDING";
      }
    },
    SHIPPED {
      @Override
      public String toString() {
        return "SHIPPED";
      }
    },
    DELIVERED {
      @Override
      public String toString() {
        return "DELIVERED";
      }
    },
    CANCELLED {
      @Override
      public String toString() {
        return "CANCELLED";
      }
    },
  }
}
