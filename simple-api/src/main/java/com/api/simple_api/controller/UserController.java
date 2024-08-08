package com.api.simple_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.FailResponder;
import com.api.simple_api.entity.common.OkResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.dto_utils.FilteredUser;
import com.api.simple_api.entity.dto_utils.ResultUser;
import com.api.simple_api.service.USerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "USer", description = "USer description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
  @Autowired
  private USerService uSerService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Long id, @RequestParam(required = false) String displayName, @RequestParam(required = false) String password, Long roleId) {
    try {
      List<ResultUser> result = uSerService.getByFilter(new FilteredUser(id, displayName, password, roleId));
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
