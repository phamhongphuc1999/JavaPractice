package com.kafka;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kafka.config.Constance;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class.getName());

	public static void main(String[] args) throws InterruptedException {
		log.info("Kafka producer wikimedia");

		String topic = "wikimedia.recentchange";

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constance.BOOTSTRAP_SERVER);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// set safe producer configs(If Kafka <= 2.8)
		properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
		properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
		properties.setProperty(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));

		// set high throughput producer configs
		properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20");
		properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32 * 1024));
		properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");

		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		EventHandler eventHandler = new WikimediaChangeHandler(producer, topic);
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(Constance.STREAM_URL));
		EventSource eventSource = builder.build();

		// start producer in another thread
		eventSource.start();

		// produce for 10 minutes and block the program until then
		TimeUnit.MINUTES.sleep(10);
	}
}