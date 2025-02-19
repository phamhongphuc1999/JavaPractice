package com.api.simple_api.controller;

import java.util.Date;

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
import com.api.simple_api.entity.common.PageableEntity;
import com.api.simple_api.entity.common.PaginationResult;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.dto.Supplier;
import com.api.simple_api.entity.dto_utils.FilteredSupplier;
import com.api.simple_api.entity.dto_utils.NewSupplier;
import com.api.simple_api.service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Supplier", description = "Supplier description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/supplier")
public class SupplierController {
  @Autowired
  public SupplierService supplierService;

  @Operation(summary = "getByFilter", description = "get supplier by filter")
  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Integer id,
      @RequestParam(required = false) String displayName,
      @RequestParam(required = false) String address, @RequestParam(required = false) String phone,
      @RequestParam(required = false) String email,
      @RequestParam(required = false) String moreInfo,
      @RequestParam(required = false) Date fromContractDate,
      @RequestParam(required = false) Date toContractDate,
      @RequestParam(required = false) Integer pageNumber,
      @RequestParam(required = false) Integer pageSize) {
    try {
      FilteredSupplier filteredSupplier = new FilteredSupplier(id, displayName, address, phone, email, moreInfo,
          fromContractDate, toContractDate);
      PaginationResult<Supplier> suppliers = supplierService.getByFilter(filteredSupplier,
          new PageableEntity(pageNumber, pageSize));
      return ResponseEntity.ok().body(new OkResponder(suppliers));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @Operation(summary = "save", description = "Create new supplier")
  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewSupplier entity) {
    try {
      Supplier newSupplier = supplierService.save(new Supplier(entity));
      return ResponseEntity.ok().body(new OkResponder(newSupplier));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
