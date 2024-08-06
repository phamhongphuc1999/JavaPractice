package com.api.simple_api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.simple_api.controller.CommonController;

@SpringBootTest
class SimpleApiApplicationTest {
  @Autowired
  private CommonController commonController;

  @Test
  void contextLoads() {
    assertThat(commonController).isNotNull();
  }
}
