package com.word.word.entity.dto_utils;

import java.util.List;

public class UpdatedCategory {
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private List<NewPair> newPairs;

  public List<NewPair> getNewPairs() {
    return this.newPairs;
  }

  public void setNewPairs(List<NewPair> newPairs) {
    this.newPairs = newPairs;
  }

  private List<UpdatePair> modifiedPairs;

  public List<UpdatePair> getModifiedPairs() {
    return this.modifiedPairs;
  }

  public void setModifiedPairs(List<UpdatePair> modifiedPairs) {
    this.modifiedPairs = modifiedPairs;
  }

  private List<Integer> removedIds;

  public List<Integer> getRemovedIds() {
    return removedIds;
  }

  public void setRemovedIds(List<Integer> removedIds) {
    this.removedIds = removedIds;
  }

  public UpdatedCategory(String title, List<NewPair> newPairs, List<UpdatePair> modifiedPairs,
      List<Integer> removedIds) {
    this.title = title;
    this.newPairs = newPairs;
    this.modifiedPairs = modifiedPairs;
    this.removedIds = removedIds;
  }
}
