package com.api.simple_api.controller;

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

import com.api.simple_api.entity.common.BadRequestResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.common.SuccessResponder;
import com.api.simple_api.entity.dto.Unit;
import com.api.simple_api.entity.dto_utils.NewUnit;
import com.api.simple_api.service.UnitService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Unit", description = "Unit description")
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/unit")
public class UnitController {
  @Autowired
  private UnitService unitService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Long id, @RequestParam(required = false, name = "Display name") String displayName) {
    try {
      List<Unit> units = unitService.getByFilter(new Unit(id, displayName));
      return ResponseEntity.ok().body(new SuccessResponder(units));
    } catch(Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewUnit entity) {
    try {
      Unit newUnit = unitService.save(new Unit(entity.getDisplayName()));
      return ResponseEntity.ok().body(new SuccessResponder(newUnit));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }
}
