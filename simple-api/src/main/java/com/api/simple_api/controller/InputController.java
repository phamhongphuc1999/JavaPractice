package com.api.simple_api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.javatuples.Pair;
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
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.common.OkResponder;
import com.api.simple_api.entity.dto.Input;
import com.api.simple_api.entity.dto.InputInfo;
import com.api.simple_api.entity.dto_utils.FilteredInput;
import com.api.simple_api.entity.dto_utils.NewInput;
import com.api.simple_api.entity.dto_utils.ResultInput;
import com.api.simple_api.service.InputService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Input", description = "Input information")
@RestController
@EnableAutoConfiguration
@RequestMapping("/input")
public class InputController {
  @Autowired
  private InputService inputService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) UUID id, @RequestParam(required = false, name = "input id") UUID infoId, @RequestParam(required = false) Long objectId, @RequestParam(required = false, name = "from input date") Date fromInputDate, @RequestParam(required = false, name = "to input date") Date toInputDate, @RequestParam(required = false, name = "from count") Integer fromCount, @RequestParam(required = false, name = "to count") Integer toCount, @RequestParam(required = false, name = "from input price") Float fromInputPrice, @RequestParam(required = false, name = "to input price") Float toInputPrice, @RequestParam(required = false) String status) {
    try {
      FilteredInput filteredInput = new FilteredInput(id, infoId, objectId, fromInputDate, toInputDate, fromCount, toCount, fromInputPrice, toInputPrice, status);
      List<ResultInput> result = inputService.getByFilter(filteredInput);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewInput entity) {
    try {
      Pair<Input, InputInfo> result = inputService.save(entity);
      HashMap<String, Object> realResult = new HashMap<String, Object>();
      realResult.put("input", result.getValue0());
      realResult.put("information", result.getValue1());
      return ResponseEntity.ok().body(new OkResponder(realResult));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  } 
}
