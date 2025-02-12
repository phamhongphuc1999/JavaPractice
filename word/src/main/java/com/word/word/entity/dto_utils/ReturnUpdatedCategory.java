package com.word.word.entity.dto_utils;

import java.util.List;

import com.word.word.entity.dto.PairDto;

public class ReturnUpdatedCategory {
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private List<PairDto> newPairs;

  public List<PairDto> getNewPairs() {
    return this.newPairs;
  }

  public void setNewPairs(List<PairDto> newPairs) {
    this.newPairs = newPairs;
  }

  private List<Integer> removedIds;

  public List<Integer> getRemovedIds() {
    return removedIds;
  }

  public void setRemovedIds(List<Integer> removedIds) {
    this.removedIds = removedIds;
  }

  public ReturnUpdatedCategory() {
  }

  public ReturnUpdatedCategory(String title, List<PairDto> newPairs, List<Integer> removedIds) {
    this.title = title;
    this.newPairs = newPairs;
    this.removedIds = removedIds;
  }
}
