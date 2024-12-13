package com.inventory;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@EntityScan(basePackages = { "com.example.entity.*" })
public class OpenAPIConfiguration {
  @Bean
  public OpenAPI defineOpenApi() {
    Server server = new Server();
    server.setUrl("http://localhost:9092");
    server.setDescription("Inventory Service");

    Contact myContact = new Contact();
    myContact.setName("Peter Present");
    myContact.setEmail("peterpresent");

    Info information = new Info()
        .title("Inventory Service")
        .version("1.0")
        .description("")
        .contact(myContact);
    return new OpenAPI().info(information).servers(List.of(server));
  }
}
