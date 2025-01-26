package com.word.word.entity.dto_utils;

import java.util.List;

public class UpdatedCategory extends NewCategory {
  private List<Integer> removedIds;

  public List<Integer> getRemovedIds() {
    return removedIds;
  }

  public void setRemovedIds(List<Integer> removedIds) {
    this.removedIds = removedIds;
  }

  public UpdatedCategory(String title, List<NewPair> pairs, List<Integer> removedIds) {
    super(title, pairs);
    this.removedIds = removedIds;
  }
}
