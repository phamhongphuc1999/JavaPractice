package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.common.FailResponder;
import com.example.entity.common.OkResponder;
import com.example.entity.common.Responder;
import com.example.entity.dto.Order;
import com.example.entity.dto_utils.NewOrder;
import com.order.service.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Common", description = "Fetch metadata, don't link to any database")
@RestController
@EnableAutoConfiguration
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewOrder entity) {
    try {
      Order result = orderService.save(new Order(entity));
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
