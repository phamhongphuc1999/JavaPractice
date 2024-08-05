package com.api.simple_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.BadRequestResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.common.SuccessResponder;
import com.api.simple_api.entity.dto_utils.NewInput;
import com.api.simple_api.service.InputService;

@RestController
@RequestMapping("/input")
public class InputController {
  @Autowired
  private InputService inputService;

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewInput entity) {
    try {
      inputService.save(entity);
      return ResponseEntity.ok().body(new SuccessResponder());
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  } 
}
