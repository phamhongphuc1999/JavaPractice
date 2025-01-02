package com.example.config;

public class KafkaConstance {
  public static String BOOTSTRAP_SERVERS_CONFIG = "127.0.0.1:19092";

  public static String GROUP_ID = "application";

  public static String ORDER_CREATED_TOPIC = "order-created";
  public static String CONFIRM_ORDER_TOPIC = "confirm-order";
  public static String PAYMENT_PROCESS_TOPIC = "payment-process";
}
