package com.inventory.RecordFactory;

import java.time.Duration;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.example.AppKafka.KafkaConsumerFactory;

public class InventoryKafkaThread {
  public static void startCustomer() {
    KafkaRecordFactory recordFactory = new KafkaRecordFactory();
    KafkaConsumer<String, String> consumer = KafkaConsumerFactory.getEntity();
    Thread consumerThread = new Thread(() -> {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
          recordFactory.process(records);
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        consumer.close();
        System.out.println("Consumer closed.");
      }
    });

    consumerThread.start();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Shutdown signal received.");
      consumerThread.interrupt();
      try {
        consumerThread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }));
  }
}
