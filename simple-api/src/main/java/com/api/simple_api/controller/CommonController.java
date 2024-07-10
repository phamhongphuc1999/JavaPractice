package com.api.simple_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

  @GetMapping("/common/hello-world")
  public String sayHelloWorld() {
    return "Hello World!";
  }
}
