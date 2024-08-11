package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangeHandler implements EventHandler {
  KafkaProducer<String, String> kafkaProducer;
  String topic;
  private static final Logger log = LoggerFactory.getLogger(WikimediaChangeHandler.class.getName());

  public WikimediaChangeHandler(KafkaProducer<String, String> kafkaProducer, String topic) {
    this.kafkaProducer = kafkaProducer;
    this.topic = topic;
  }

  @Override
  public void onOpen() {

  }

  @Override
  public void onClosed() {
    kafkaProducer.close();
  }

  @Override
  public void onMessage(String event, MessageEvent messageEvent) throws Exception {
    log.info(messageEvent.getData());
    ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, messageEvent.getData());
    kafkaProducer.send(record);
  }

  @Override
  public void onComment(String comment) throws Exception {

  }

  @Override
  public void onError(Throwable t) {
    log.error("Error in Stream Reading", t);
  }
}
