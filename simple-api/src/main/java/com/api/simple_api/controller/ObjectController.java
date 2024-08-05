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
import com.api.simple_api.entity.dto.ObjectDto;
import com.api.simple_api.entity.dto_utils.FilteredObjectDto;
import com.api.simple_api.entity.dto_utils.NewObjectDto;
import com.api.simple_api.service.ObjectService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Object", description = "object description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/object")
public class ObjectController {
  @Autowired
  private ObjectService objectService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Long id, @RequestParam(required = false) String displayName, @RequestParam(required = false) Long unitId, @RequestParam(required = false) Long supplierId, @RequestParam(required = false) String qrCode, @RequestParam(required = false) String barCode) {
    try {
      List<ObjectDto> objects = objectService.getByFilter(new FilteredObjectDto(id, displayName, unitId, supplierId, qrCode, barCode));
      return ResponseEntity.ok().body(new SuccessResponder(objects));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewObjectDto entity) {
    try {
      objectService.save(new ObjectDto(entity));
      return ResponseEntity.ok().body(new SuccessResponder());
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }
}
