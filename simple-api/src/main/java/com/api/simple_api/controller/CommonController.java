package com.api.simple_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.Responder;

@RestController
@RequestMapping("/common")
public class CommonController {
  @GetMapping("/hello")
  public ResponseEntity<Responder> hello() {
    return ResponseEntity.ok().body(new Responder("Greeting from Spring Boot!", null));
  }
}
