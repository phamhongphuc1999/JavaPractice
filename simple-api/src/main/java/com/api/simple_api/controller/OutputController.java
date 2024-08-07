package com.api.simple_api.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
import com.api.simple_api.entity.dto.Output;
import com.api.simple_api.entity.dto.OutputInfo;
import com.api.simple_api.entity.dto_utils.NewOutput;
import com.api.simple_api.entity.dto_utils.ResultOutput;
import com.api.simple_api.service.OutputService;

import org.javatuples.Pair;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Output", description = "Output description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/output")
public class OutputController {
  @Autowired
  private OutputService outputService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter() {
    try {
      List<ResultOutput> result = outputService.getByFilter();
      return ResponseEntity.ok().body(new SuccessResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewOutput entity) {
    try {
      Pair<Output, OutputInfo> result = outputService.save(entity);
      if (result == null)
        return ResponseEntity.ok().body(new BadRequestResponder("Current count is not enough"));
      HashMap<String, Object> realResult = new HashMap<String, Object>();
      realResult.put("output", result.getValue0());
      realResult.put("information", result.getValue1());
      return ResponseEntity.ok().body(new SuccessResponder(realResult));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponder(exception.getMessage()));
    }
  }
}
