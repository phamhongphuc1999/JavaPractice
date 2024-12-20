package com.kafka.producer;

import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		log.info("-------------------------Kafka Producer-------------------------");

		String bootstrapServers = "127.0.0.1:19092";

		// create Producer properties
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		// create a producer record
		String topic = "demo_java";
		String key = "id";
		SimpleObject s = new SimpleObject("param1", 1, UUID.randomUUID());

		Gson gson = new Gson();
		String serializedObject = gson.toJson(s);

		ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic,
				key, serializedObject);

		// send data - asynchronous
		producer.send(producerRecord, new Callback() {
			public void onCompletion(RecordMetadata recordMetadata, Exception e) {
				if (e == null) {
					log.info("Received new metadata. \n" +
							"Topic:" + recordMetadata.topic() + "\n" +
							"Key:" + producerRecord.key() + "\n" +
							"Partition: " + recordMetadata.partition() + "\n" +
							"Offset: " + recordMetadata.offset() + "\n" +
							"Timestamp: " + recordMetadata.timestamp());
				} else {
					log.error("Error while producing", e);
				}
			}
		});

		// flush data - synchronous
		producer.flush();
		// flush and close producer
		producer.close();

		System.out.print("Done!");
	}
}