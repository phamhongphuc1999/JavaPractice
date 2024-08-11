package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemo {
	private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

	public static void main(String[] args) {
		log.info("Kafka producer!");

		// set properties for localhost
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "127.0.0.1:19092");

		// set common properties
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		properties.setProperty("batch.size", "400");
		// properties.setProperty("partitioner.class",
		// RoundRobinPartitioner.class.getName());

		// create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		for (int i = 0; i < 10; i++) {
			String key = "id_" + i;
			String value = "value_" + i;
			// create producer record
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("third_topic", key, value);

			// send data
			producer.send(producerRecord, new Callback() {
				@Override
				public void onCompletion(RecordMetadata metadata, Exception e) {
					// executes every time a record successfully sent or an exception is thrown
					if (e == null) {
						log.info("Receive new metadata \n" +
								"Topic: " + metadata.topic() + "\n" +
								"Offset: " + metadata.offset() + "\n" +
								"Key: " + key + " | Partition: " + metadata.partition() + "\n" +
								"Timestamp: " + metadata.timestamp());
					} else {
						log.error("Error while producer", e);
					}
				}
			});
		}

		// flush and close producer
		producer.flush();
		producer.close();
	}
}