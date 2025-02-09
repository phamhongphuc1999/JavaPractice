package com.word.word.entity.commons;

import java.util.List;

public class PaginationResult<T> {
  private Integer total;

  public Integer getTotal() {
    return this.total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  private List<T> items;

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

  public PaginationResult(Integer total, List<T> items) {
    this.total = total;
    this.items = items;
  }
}
