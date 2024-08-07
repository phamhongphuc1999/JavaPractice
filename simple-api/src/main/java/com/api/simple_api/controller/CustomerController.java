package com.api.simple_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.FailResponder;
import com.api.simple_api.entity.common.OkResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.dto.Customer;
import com.api.simple_api.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Customer", description = "Customer description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/customer")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter() {
    try {
      List<Customer> result = customerService.getByFilter();
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
