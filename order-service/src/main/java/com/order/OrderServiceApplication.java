package com.order;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.order.AppKafka.KafkaProducerFactory;

@SpringBootApplication
@EntityScan(basePackages = { "com.example.entity.*" })
public class OrderServiceApplication {

  public static void main(String[] args) {
    KafkaProducerFactory.create();
    SpringApplication.run(OrderServiceApplication.class, args);
  }

  @SuppressWarnings("unused")
  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext context) {
    return arg -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");
      String[] beanNames = context.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }
}
