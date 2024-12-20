package com.example.config;

public class KafkaConstance {
  public static String BOOTSTRAP_SERVERS_CONFIG = "127.0.0.1:19092";

  public static String GROUP_ID = "application";

  public static String ORDER_CREATED_TOPIC = "order-created";
  public static String INVENTORY_UPDATE_TOPIC = "inventory-update";
  public static String PAYMENT_PROCESS_TOPIC = "payment-process";
}
