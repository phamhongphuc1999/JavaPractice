package com.api.simple_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.BadRequestResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.common.SuccessResponder;
import com.api.simple_api.entity.dto.Unit;
import com.api.simple_api.service.UnitService;

@RestController
@RequestMapping("/unit")
public class UnitController {
  @Autowired
  private UnitService unitService;

  @GetMapping("")
  public ResponseEntity<Responder> getAll() {
    try {
      List<Unit> units = unitService.getAll();
      return ResponseEntity.ok().body(new SuccessResponder(units));
    } catch(Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody Unit entity) {
    try {
      unitService.save(entity);
      return ResponseEntity.ok().body(new SuccessResponder());
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }
}
