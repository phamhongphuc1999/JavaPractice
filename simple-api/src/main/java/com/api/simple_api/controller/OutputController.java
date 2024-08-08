package com.api.simple_api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import com.api.simple_api.entity.dto.Output;
import com.api.simple_api.entity.dto.OutputInfo;
import com.api.simple_api.entity.dto_utils.FilteredOutput;
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
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) UUID id, @RequestParam(required = false, name = "output id") UUID infoId, @RequestParam(required = false, name = "object id") Long objectId, @RequestParam(required = false, name = "customer id") Long customerId, @RequestParam(required = false, name = "from output date") Date fromOutputDate, @RequestParam(required = false, name = "to output date") Date toOutputDate, @RequestParam(required = false) Integer count, @RequestParam(required = false, name = "from output price") Float fromOutputPrice, @RequestParam(required = false, name = "to output price") Float toOutputPrice, @RequestParam(required = false) String status, @RequestParam(required = false, name = "object name") String objectName, @RequestParam(required = false, name = "unit name") String unitName, @RequestParam(required = false, name = "customer name") String customerName) {
    try {
      FilteredOutput filteredOutput = new FilteredOutput(id, infoId, objectId, customerId, fromOutputDate, toOutputDate, count, fromOutputPrice, toOutputPrice, status, objectName, unitName, customerName);
      List<ResultOutput> result = outputService.getByFilter(filteredOutput);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewOutput entity) {
    try {
      Pair<Output, OutputInfo> result = outputService.save(entity);
      if (result == null)
        return ResponseEntity.ok().body(new FailResponder("Current count is not enough"));
      HashMap<String, Object> realResult = new HashMap<String, Object>();
      realResult.put("output", result.getValue0());
      realResult.put("information", result.getValue1());
      return ResponseEntity.ok().body(new OkResponder(realResult));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
