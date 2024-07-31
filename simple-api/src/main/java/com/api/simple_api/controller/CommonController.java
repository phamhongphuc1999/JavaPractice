package com.api.simple_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {
  @GetMapping("/hello")
  public String hello() {
    return "Greeting from Spring Boot!";
  }
}
