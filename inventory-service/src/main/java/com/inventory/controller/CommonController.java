package com.inventory.controller;

import java.util.Set;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppKafka.KafkaProducerFactory;
import com.example.entity.KafkaTopicData;
import com.example.entity.common.FailResponder;
import com.example.entity.common.OkResponder;
import com.example.entity.common.Responder;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Common", description = "Fetch metadata, don't link to any database")
@RestController
@EnableAutoConfiguration
@RequestMapping("/inventory/common")
public class CommonController {
  @GetMapping("/hello")
  public ResponseEntity<Responder> hello() {
    return ResponseEntity.ok().body(new OkResponder("Welcome to Inventory Service"));
  }

  @GetMapping("/kafka-topics")
  public ResponseEntity<Responder> kafkaTopics() {
    try {
      AdminClient client = KafkaProducerFactory.getAdmin();
      ListTopicsResult topics = client.listTopics();
      Set<String> names = topics.names().get();
      return ResponseEntity.ok().body(new OkResponder(new KafkaTopicData(names)));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
