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
    ORDER_OK {
      @Override
      public String toString() {
        return "ORDER_OK";
      }
    },
    FULL_ORDER {
      @Override
      public String toString() {
        return "FULL_ORDER";
      }
    },
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
