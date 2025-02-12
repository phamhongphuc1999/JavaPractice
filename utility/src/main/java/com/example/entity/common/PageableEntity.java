package com.example.entity.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageableEntity {
  private Integer pageNumber;

  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  private Integer pageSize;

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  private Pageable pageable;

  public Pageable getPageable() {
    return this.pageable;
  }

  public PageableEntity() {
    this.pageNumber = 0;
    this.pageSize = 10;
    this.pageable = PageRequest.of(this.pageNumber, this.pageSize);
  }

  public PageableEntity(Integer pageNumber, Integer pageSize) {
    if (pageNumber != null)
      this.pageNumber = pageNumber;
    else
      this.pageNumber = 0;

    if (pageSize != null)
      this.pageSize = pageSize;
    else
      this.pageSize = 10;

    this.pageable = PageRequest.of(this.pageNumber, this.pageSize);
  }
}
