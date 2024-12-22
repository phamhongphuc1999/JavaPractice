package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import com.example.config.KafkaConstance;

public class KafkaTopicData {
  public Set<String> names;
  public Set<String> orderTopics;

  public KafkaTopicData(Set<String> names) {
    this.names = names;
    this.orderTopics = new HashSet<>();
    this.orderTopics.add(KafkaConstance.ORDER_CREATED_TOPIC);
    this.orderTopics.add(KafkaConstance.INVENTORY_UPDATE_TOPIC);
    this.orderTopics.add(KafkaConstance.PAYMENT_PROCESS_TOPIC);
  }
}