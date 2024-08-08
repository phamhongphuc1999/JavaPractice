package com.api.simple_api.controller;

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

import com.api.simple_api.entity.common.FailResponder;
import com.api.simple_api.entity.common.OkResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.dto.Customer;
import com.api.simple_api.entity.dto_utils.FilteredCustomer;
import com.api.simple_api.entity.dto_utils.NewCustomer;
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
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Long id, @RequestParam(required = false) String displayName, @RequestParam(required = false) String address, @RequestParam(required = false) String phone, @RequestParam(required = false) String email, @RequestParam(required = false) String moreInfo, @RequestParam(required = false) Date fromContractDate, @RequestParam(required = false) Date toContractDate) {
    try {
      FilteredCustomer filteredCustomer = new FilteredCustomer(id, displayName, address, phone, email, moreInfo, fromContractDate, toContractDate);
      List<Customer> result = customerService.getByFilter(filteredCustomer);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewCustomer entity) {
    try {
      Customer result = customerService.save(new Customer(entity));
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
