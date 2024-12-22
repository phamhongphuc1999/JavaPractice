package com.example.AppKafka;

import java.util.Properties;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import com.example.config.KafkaConstance;

public class KafkaProducerFactory {
  private static AdminClient adminClient;
  private static KafkaProducer<String, String> producer;

  public static void createAdmin() {
    if (adminClient == null) {
      // create Producer properties
      Properties properties = new Properties();
      properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstance.BOOTSTRAP_SERVERS_CONFIG);
      properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
      properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

      // create admin
      KafkaProducerFactory.adminClient = KafkaAdminClient.create(properties);
    }
  }

  public static AdminClient getAdmin() {
    KafkaProducerFactory.createAdmin();
    return KafkaProducerFactory.adminClient;
  }

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
