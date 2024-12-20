package com.order.AppKafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import com.example.config.KafkaConstance;

public class KafkaProducerFactory {
  private static KafkaProducer<String, String> producer;

  public static void create() {
    if (producer == null) {
      // create Producer properties
      Properties properties = new Properties();
      properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstance.BOOTSTRAP_SERVERS_CONFIG);
      properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
      properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

      // create the producer
      KafkaProducerFactory.producer = new KafkaProducer<>(properties);
    }
  }

  public static KafkaProducer<String, String> getEntity() {
    KafkaProducerFactory.create();
    return KafkaProducerFactory.producer;
  }
}
