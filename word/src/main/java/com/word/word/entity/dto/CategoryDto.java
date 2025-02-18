package com.word.word.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.word.word.entity.dto_utils.NewCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @Column(name = "user_id")
  private Integer userId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "create_at")
  private Date createAt;

  public Date getCreateAt() {
    return this.createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "update_at")
  private Date updateAt;

  public Date getUpdateAt() {
    return this.updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }

  public CategoryDto() {
  }

  public CategoryDto(Integer userId, NewCategory entity) {
    this.userId = userId;
    this.title = entity.getTitle();
    this.createAt = new Date();
    this.updateAt = new Date();
  }
}
