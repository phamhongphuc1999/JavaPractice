package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kafka.config.Constance;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class.getName());

	public static void main(String[] args) {
		log.info("Kafka producer wikimedia");

		String topic = "wikimedia.recentchange";

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constance.BOOTSTRAP_SERVER);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		// BackgroundEventHandler eventHandler = TODO;

		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, "key1", "hello world");

		producer.send(record);

		producer.flush();
		producer.close();
	}
}