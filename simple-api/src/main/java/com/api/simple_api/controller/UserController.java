package com.api.simple_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.simple_api.entity.common.FailResponder;
import com.api.simple_api.entity.common.OkResponder;
import com.api.simple_api.entity.common.Responder;
import com.api.simple_api.entity.dto.UserDto;
import com.api.simple_api.entity.dto_utils.FilteredUser;
import com.api.simple_api.entity.dto_utils.JwtResponseUser;
import com.api.simple_api.entity.dto_utils.JwtUser;
import com.api.simple_api.entity.dto_utils.NewUser;
import com.api.simple_api.entity.dto_utils.ResultUser;
import com.api.simple_api.service.UserService;
import com.api.simple_api.utils.JwtTokenUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "User description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Long id,
      @RequestParam(required = false, name = "display name") String displayName,
      @RequestParam(required = false) String password, @RequestParam(required = false, name = "role id") Long roleId) {
    try {
      List<ResultUser> result = userService.getByFilter(new FilteredUser(id, displayName, password, roleId));
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewUser entity) {
    try {
      UserDto result = userService.save(new UserDto(entity));
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @PostMapping("/login")
  public ResponseEntity<Responder> login(@RequestBody JwtUser jwtUser) {
    try {
      authenticate(jwtUser.getUsername(), jwtUser.getPassword());
      final UserDetails userDetails = userService
          .loadUserByUsername(jwtUser.getUsername());
      final String token = jwtTokenUtil.generateToken(userDetails);
      return ResponseEntity.ok(new OkResponder(new JwtResponseUser(token)));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
