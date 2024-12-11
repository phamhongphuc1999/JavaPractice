package com.api.simple_api;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {
  @Bean
  public OpenAPI defineOpenApi() {
    Server server = new Server();
    server.setUrl("http://localhost:9090");
    server.setDescription("Simple Spring Boot API");

    Contact myContact = new Contact();
    myContact.setName("Peter Present");
    myContact.setEmail("peterpresent");

    Info information = new Info()
        .title("Symple API")
        .version("1.0")
        .description("")
        .contact(myContact);
    return new OpenAPI().info(information).servers(List.of(server));
  }
}
