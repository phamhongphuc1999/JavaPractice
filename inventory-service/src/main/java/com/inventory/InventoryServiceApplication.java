package com.inventory;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.AppKafka.KafkaConsumerFactory;
import com.example.AppKafka.KafkaProducerFactory;
import com.example.config.KafkaConstance;
import com.inventory.RecordFactory.InventoryKafkaThread;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		KafkaProducerFactory.create();
		KafkaConsumerFactory.create();
		KafkaConsumerFactory.getEntity().subscribe(Arrays.asList(KafkaConstance.ORDER_CREATED_TOPIC));
		InventoryKafkaThread.startCustomer();
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

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
