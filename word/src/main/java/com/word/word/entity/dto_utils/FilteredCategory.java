package com.word.word.entity.dto_utils;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FilteredCategory {
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private Integer userId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date fromCreateAt;

  public Date getFromCreateAt() {
    return fromCreateAt;
  }

  public void setFromCreateAt(Date fromCreateAt) {
    this.fromCreateAt = fromCreateAt;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date toCreateAt;

  public Date getToCreateAt() {
    return toCreateAt;
  }

  public void setToCreateAt(Date toCreateAt) {
    this.toCreateAt = toCreateAt;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date fromUpdateAt;

  public Date getFromUpdateAt() {
    return fromUpdateAt;
  }

  public void setFromUpdateAt(Date fromUpdateAt) {
    this.fromUpdateAt = fromUpdateAt;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date toUpdateAt;

  public Date getToUpdateAt() {
    return toUpdateAt;
  }

  public void setToUpdateAt(Date toUpdateAt) {
    this.toUpdateAt = toUpdateAt;
  }

  public FilteredCategory(Integer id, String title, Integer userId) {
    this.id = id;
    this.title = title;
    this.userId = userId;
  }

  public FilteredCategory(Integer id, String title, Integer userId, Date fromCreateAt, Date toCreateAt,
      Date fromUpdateAt, Date toUpdateAt) {
    this.id = id;
    this.title = title;
    this.userId = userId;
    this.fromCreateAt = fromCreateAt;
    this.toCreateAt = toCreateAt;
    this.fromUpdateAt = fromUpdateAt;
    this.toUpdateAt = toUpdateAt;
  }
}
