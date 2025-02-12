package com.word.word.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.common.FailResponder;
import com.example.entity.common.OkResponder;
import com.example.entity.common.PageableEntity;
import com.example.entity.common.PaginationResult;
import com.example.entity.common.Responder;
import com.word.word.entity.dto.CategoryDto;
import com.word.word.entity.dto.PairDto;
import com.word.word.entity.dto_utils.FilteredCategory;
import com.word.word.entity.dto_utils.NewCategory;
import com.word.word.entity.dto_utils.ResultCategory;
import com.word.word.entity.dto_utils.ResultUser;
import com.word.word.entity.dto_utils.SavedResultCategory;
import com.word.word.entity.dto_utils.UpdatedCategory;
import com.word.word.service.CategoryService;
import com.word.word.service.UserService;
import com.word.word.utils.JwtTokenUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Category", description = "Category description")
@RestController
@EnableAutoConfiguration
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserService userService;

  @Autowired
  private CategoryService categoryService;

  @Operation(summary = "Get your categories by filter", description = "Get your categories by filter")
  @GetMapping("")
  public ResponseEntity<Responder> getByFilter(
      @RequestHeader(value = "Authorization", required = true) String authorizationHeader,
      @RequestParam(required = false) Integer id,
      @RequestParam(required = false) String title,
      @RequestParam(required = false) Integer pageNumber,
      @RequestParam(required = false) Integer pageSize) {
    try {
      String realAuthorization = authorizationHeader.replace("Bearer ", "");
      String username = jwtTokenUtil.getUsernameFromToken(realAuthorization);
      ResultUser user = userService.getByUsername(username);
      FilteredCategory filteredCategory = new FilteredCategory(id, title, user.getId());
      PaginationResult<ResultCategory> result = categoryService.getByFilter(filteredCategory,
          new PageableEntity(pageNumber, pageSize));
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @Operation(summary = "Create category", description = "Create category")
  @PostMapping("")
  public ResponseEntity<Responder> save(
      @RequestHeader(value = "Authorization", required = true) String authorizationHeader,
      @RequestBody NewCategory entity) {
    try {
      String realAuthorization = authorizationHeader.replace("Bearer ", "");
      String username = jwtTokenUtil.getUsernameFromToken(realAuthorization);
      ResultUser user = userService.getByUsername(username);
      CategoryDto newCategory = new CategoryDto(user.getId(), entity);
      SavedResultCategory result = categoryService.save(newCategory, entity.getPairs());
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @Operation(summary = "Update category", description = "Update category")
  @PutMapping("")
  public ResponseEntity<Responder> updateCategory(
      @RequestHeader(value = "Authorization", required = true) String authorizationHeader,
      @RequestParam(required = true) Integer categoryId,
      @RequestBody UpdatedCategory entity) {
    try {
      String realAuthorization = authorizationHeader.replace("Bearer ", "");
      String username = jwtTokenUtil.getUsernameFromToken(realAuthorization);
      ResultUser user = userService.getByUsername(username);
      List<PairDto> result = categoryService.update(user.getId(), categoryId, entity);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }

  @Operation(summary = "Delete category", description = "Delete category")
  @DeleteMapping("")
  public ResponseEntity<Responder> deleteCategory(
      @RequestHeader(value = "Authorization", required = true) String authorizationHeader,
      @RequestParam(required = true) Integer categoryId) {
    try {
      String realAuthorization = authorizationHeader.replace("Bearer ", "");
      String username = jwtTokenUtil.getUsernameFromToken(realAuthorization);
      ResultUser user = userService.getByUsername(username);
      boolean result = categoryService.delete(user.getId(), categoryId);
      return ResponseEntity.ok().body(new OkResponder(result));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponder(exception.getMessage()));
    }
  }
}
