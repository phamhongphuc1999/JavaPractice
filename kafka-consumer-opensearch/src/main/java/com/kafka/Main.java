package com.kafka;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.indices.GetIndexRequest;
import org.opensearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kafka.config.Constance;

public class Main {
	private static KafkaConsumer<String, String> createConsumer() {
		String groupId = "my-java-application";

		// create consumer properties
		Properties properties = new Properties();

		// set properties for localhost
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constance.BOOTSTRAP_SERVER);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

		// create a consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		return consumer;
	}

	public static void main(String[] args) throws IOException {
		Logger log = LoggerFactory.getLogger(Main.class.getName());

		// first create an OpenSearch client
		RestHighLevelClient openSearchClient = CreateOpenSearchClient.create();

		KafkaConsumer<String, String> consumer = createConsumer();

		final Thread mainThread = Thread.currentThread();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				log.info("Detected a shutdown, let's exit by calling consumer.wakeup()");
				consumer.wakeup();

				try {
					mainThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		try (openSearchClient; consumer) {
			GetIndexRequest getIndexRequest = new GetIndexRequest("wikimedia");
			boolean indexExist = openSearchClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
			if (!indexExist) {
				CreateIndexRequest createIndexRequest = new CreateIndexRequest("wikimedia");
				openSearchClient.indices().create(createIndexRequest,
						RequestOptions.DEFAULT);
			} else
				log.warn("wikimedia is exist");

			consumer.subscribe(Collections.singleton("wikimedia.recentchange"));

			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(3000));

				int recordCount = records.count();
				log.info("Received: " + recordCount + " record(s)");

				BulkRequest bulkRequest = new BulkRequest();

				for (ConsumerRecord<String, String> record : records) {
					try {
						String id = JsonExtraction.extractId(record.value());
						// send into OpenSearch
						IndexRequest indexRequest = new IndexRequest("wikimedia").source(record.value(), XContentType.JSON).id(id);

						bulkRequest.add(indexRequest);

						// IndexResponse response = openSearchClient.index(indexRequest,
						// RequestOptions.DEFAULT);

						// log.info("Inserted 1 document: " + response.getId());
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}

				if (bulkRequest.numberOfActions() > 0) {
					BulkResponse bulkResponse = openSearchClient.bulk(bulkRequest, RequestOptions.DEFAULT);

					log.info("Inserted: " + bulkResponse.getItems().length + " record(s)");

					// commit offsets after the batch is consumed
					consumer.commitSync();
					log.info("Offsets have been committed");
				}
			}
		} catch (WakeupException e) {
			log.info("Consumer is starting to shutdown");
		} catch (Exception e) {
			log.error("Unexpected exception in the consumer", e);
		} finally {
			consumer.close();
			openSearchClient.close();
			log.info("Client is shutdown gracefully!");
		}
	}
}