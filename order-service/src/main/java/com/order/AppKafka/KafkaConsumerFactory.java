package com.order.AppKafka;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.example.config.KafkaConstance;

public class KafkaConsumerFactory {
  private static KafkaConsumer<String, String> consumer;

  private static void create() {
    if (consumer == null) {
      // create consumer configs
      Properties properties = new Properties();
      properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstance.BOOTSTRAP_SERVERS_CONFIG);
      properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
      properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
      properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstance.GROUP_ID);
      properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

      // create consumer
      KafkaConsumerFactory.consumer = new KafkaConsumer<>(properties);
    }
  }

  public static KafkaConsumer<String, String> getEntity() {
    KafkaConsumerFactory.create();
    return KafkaConsumerFactory.consumer;
  }
}
