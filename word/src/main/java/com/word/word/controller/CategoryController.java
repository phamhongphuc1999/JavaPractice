package com.word.word.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.common.OkResponder;
import com.example.entity.common.Responder;

@Tag(name = "Category", description = "Category description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/category")
public class CategoryController {
  @GetMapping("/hello")
  public ResponseEntity<Responder> hello() {
    return ResponseEntity.ok().body(new OkResponder("Welcome to WordApp"));
  }
}
