package com.word.word.controller;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.common.FailResponder;
import com.example.entity.common.OkResponder;
import com.example.entity.common.Responder;
import com.word.word.entity.dto.UserDto;
import com.word.word.entity.dto_utils.FilteredUser;
import com.word.word.entity.dto_utils.JwtResponseUser;
import com.word.word.entity.dto_utils.JwtUser;
import com.word.word.entity.dto_utils.NewUser;
import com.word.word.entity.dto_utils.ResultUser;
import com.word.word.service.UserService;
import com.word.word.utils.JwtTokenUtil;

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
  public ResponseEntity<Responder> getByFilter(@RequestParam(required = false) Integer id,
      @RequestParam(required = false, name = "display name") String displayName,
      @RequestParam(required = false) String password) {
    try {
      List<ResultUser> result = userService.getByFilter(new FilteredUser(id, displayName, password));
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @PostMapping("")
  public ResponseEntity<Responder> save(@RequestBody NewUser entity) {
    try {
      UserDto newUser = new UserDto(entity);
      UserDto result = userService.save(newUser);
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

  @DeleteMapping("")
  public ResponseEntity<Responder> delete(@RequestParam(required = true) Integer id) {
    try {
      boolean result = userService.deleteUser(id);
      return ResponseEntity.ok().body(new OkResponder(result));
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
