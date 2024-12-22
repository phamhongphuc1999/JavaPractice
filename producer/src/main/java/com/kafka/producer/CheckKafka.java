package com.kafka.producer;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckKafka {
  private static final Logger log = LoggerFactory.getLogger(CheckKafka.class);

  public static void run() {
    String bootstrapServers = "127.0.0.1:19092";

    // create Producer properties
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    try (AdminClient client = KafkaAdminClient.create(properties)) {
      ListTopicsResult topics = client.listTopics();
      Set<String> names = topics.names().get();
      if (names.isEmpty()) {
        log.info("Topic is empty");
      } else {
        for (String name : names) {
          log.info("name: " + name);
        }
      }
    } catch (InterruptedException | ExecutionException e) {
      log.info("Kafka is not available");
    }
  }
}
