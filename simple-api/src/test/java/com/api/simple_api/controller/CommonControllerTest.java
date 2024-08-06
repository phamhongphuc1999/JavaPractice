package com.api.simple_api.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.api.simple_api.entity.common.Responder;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CommonControllerTest {
  @Autowired
  private TestRestTemplate template;
  
  @Test
  public void getHello() throws Exception {
    ResponseEntity<Responder> response = template.getForEntity("/common/hello", Responder.class);
    Responder body = response.getBody();
    if (body != null) {
      assertThat(body.getData()).isEqualTo("Welcome to Spring boot!");
    }
  }
}
