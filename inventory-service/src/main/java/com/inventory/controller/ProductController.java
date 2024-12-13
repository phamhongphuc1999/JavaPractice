package com.inventory.controller;

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
import com.example.entity.dto.Product;
import com.example.entity.dto_utils.FilteredProduct;
import com.example.entity.dto_utils.NewProduct;
import com.inventory.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product", description = "Product")
@RestController
@EnableAutoConfiguration
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Integer id,
      @RequestParam(required = false) String name, @RequestParam(required = false) Integer supplierId,
      @RequestParam(required = false) Integer quantity, @RequestParam(required = false) Date fromCreateAt,
      @RequestParam(required = false) Date toCreateAt, @RequestParam(required = false) Date fromUpdateAt,
      @RequestParam(required = false) Date toUpdateAt) {
    try {
      FilteredProduct filterProvider = new FilteredProduct(id, name, supplierId, quantity, fromCreateAt, toCreateAt,
          fromUpdateAt, toUpdateAt);
      List<Product> result = productService.getByFilter(filterProvider);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewProduct entity) {
    try {
      Product newProduct = productService.save(new Product(entity));
      return ResponseEntity.ok().body(new OkResponder(newProduct));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
