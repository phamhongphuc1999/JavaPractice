package com.api.simple_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.FailResponder;
import com.api.simple_api.entity.common.OkResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.dto.UserRole;
import com.api.simple_api.service.UserRoleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "UserRole", description = "User role description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/user-role")
public class UserRoleController {
  @Autowired
  private UserRoleService userRoleService;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter() {
    try {
      List<UserRole> result = userRoleService.getByFilter();
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
