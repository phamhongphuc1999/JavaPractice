package com.api.simple_api.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.common.SuccessResponder;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Common", description = "Fetch metadata, don't link to any database")
@RestController
@EnableAutoConfiguration
@RequestMapping("/common")
public class CommonController {
  @GetMapping("/hello")
  public ResponseEntity<Responder> hello() {
    return ResponseEntity.ok().body(new SuccessResponder("Welcome to Spring boot!"));
  }
}
