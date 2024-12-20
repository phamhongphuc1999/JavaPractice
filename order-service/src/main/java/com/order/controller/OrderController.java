package com.order.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.common.FailResponder;
import com.example.entity.common.OkResponder;
import com.example.entity.common.Responder;
import com.example.entity.dto.OrderTable;
import com.example.entity.dto_utils.FilteredOrder;
import com.example.entity.dto_utils.NewOrder;
import com.example.entity.dto_utils.SaveOrderResult;
import com.order.service.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order", description = "Order")
@RestController
@EnableAutoConfiguration
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Integer id,
      @RequestParam(required = false) Integer customerId, @RequestParam(required = false) Date fromOrderDate,
      @RequestParam(required = false) Date toOrderDate, @RequestParam(required = false) String status,
      @RequestParam(required = false) Integer fromTotalAmount, @RequestParam(required = false) Integer toTotalAmount,
      @RequestParam(required = false) String paymentMethodName, @RequestParam(required = false) Date fromCreateAt,
      @RequestParam(required = false) Date toCreateAt) {
    try {
      FilteredOrder filteredOrder = new FilteredOrder(id, customerId, fromOrderDate, toOrderDate, status,
          fromTotalAmount, toTotalAmount, paymentMethodName, fromCreateAt, toCreateAt);
      List<OrderTable> result = orderService.getByFilter(filteredOrder);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @GetMapping("/id")
  public ResponseEntity<Responder> getById(@RequestParam(required = false) Integer id) {
    try {
      SaveOrderResult result = orderService.getOrderById(id);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

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
