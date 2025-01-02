package com.inventory.RecordFactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecords;

import com.example.Serialization;
import com.example.config.KafkaConstance;
import com.example.entity.dto_utils.SavedNewOrder;

public class KafkaRecordFactory {
  private ProductSimulation productSimulation;

  public KafkaRecordFactory() {
    this.productSimulation = new ProductSimulation();
  }

  public void process(ConsumerRecords<String, String> records) {
    List<SavedNewOrder> newOrders = new ArrayList<>();
    records.forEach(record -> {
      System.out.printf(
          "Consumed message: Key = %s, Value = %s, Offset = %d%n",
          record.key(), record.value(), record.offset());
      String topic = record.topic();
      if (topic == KafkaConstance.ORDER_CREATED_TOPIC)
        newOrders.add(Serialization.fromJson(record.value(), SavedNewOrder.class));
      productSimulation.saveNewOrders(newOrders);
    });
  }
}
