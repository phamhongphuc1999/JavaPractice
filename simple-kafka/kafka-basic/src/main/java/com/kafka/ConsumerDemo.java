package com.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemo {
  private static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class.getName());

  public static void main(String[] args) {
    log.info("Kafka consumer!");
    String groupId = "my-java-application";

    // create consumer properties
    Properties properties = new Properties();

    // set properties for localhost
    properties.setProperty("bootstrap.servers", "127.0.0.1:19092");

    // create consumer configs
    properties.setProperty("key.deserializer", StringDeserializer.class.getName());
    properties.setProperty("value.deserializer", StringDeserializer.class.getName());
    properties.setProperty("group.id", groupId);
    properties.setProperty("auto.offset.reset", "earliest");

    // create a consumer
    KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

    final Thread mainThread = Thread.currentThread();
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        log.info("Detected a shutdown, let's exit by calling consumer.wakeup()");
        consumer.wakeup();

        try {
          mainThread.join();
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    try {
      // subscribe to a topic
      consumer.subscribe(Arrays.asList("third_topic"));

      // poll for data
      while (true) {
        log.info("Polling...");
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

        for (ConsumerRecord<String, String> record: records) {
          log.info("Key: " + record.key() + " Value: " + record.value() + " Partition: " + record.partition() + " Offset: " + record.offset());
        }
      }
    } catch(WakeupException e) {
      log.info("Consumer is starting to shut down");
    } catch(Exception e) {
      log.error("Unexpected exception is in the consumer", e);
    } finally {
      consumer.close();
      log.info("The consumer is now gracefully shut down");
    }
  }
}
