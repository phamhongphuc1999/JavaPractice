package com.word.word;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@SuppressWarnings("unused")
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return arg -> {
			System.out.println("Application running...");
			// String[] beanNames = context.getBeanDefinitionNames();
			// Arrays.sort(beanNames);
			// for (String beanName : beanNames) {
			// System.out.println(beanName);
			// }
		};
	}
}
