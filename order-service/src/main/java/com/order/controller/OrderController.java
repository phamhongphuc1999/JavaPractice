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
import com.example.entity.dto.OrderTable;
import com.example.entity.dto_utils.NewOrder;
import com.example.entity.dto_utils.SaveOrderResult;
import com.order.service.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order", description = "Create new order")
@RestController
@EnableAutoConfiguration
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewOrder entity) {
    try {
      SaveOrderResult result = orderService.save(new OrderTable(entity), entity.getOrderDetails());
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
