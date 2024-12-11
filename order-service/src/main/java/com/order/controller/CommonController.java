package com.order.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.common.OkResponder;
import com.order.entity.common.Responder;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Common", description = "Fetch metadata, don't link to any database")
@RestController
@EnableAutoConfiguration
@RequestMapping("/order/common")
public class CommonController {
  @GetMapping("/hello")
  public ResponseEntity<Responder> hello() {
    return ResponseEntity.ok().body(new OkResponder("Welcome to Order Service"));
  }
}
