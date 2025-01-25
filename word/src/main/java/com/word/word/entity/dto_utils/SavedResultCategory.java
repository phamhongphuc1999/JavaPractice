package com.word.word.entity.dto_utils;

import java.util.List;

import com.word.word.entity.dto.CategoryDto;
import com.word.word.entity.dto.PairDto;

public class SavedResultCategory {
  private CategoryDto category;

  public CategoryDto getCategory() {
    return this.category;
  }

  public void setCategory(CategoryDto category) {
    this.category = category;
  }

  private List<PairDto> pairs;

  public List<PairDto> getPairs() {
    return pairs;
  }

  public void setPairs(List<PairDto> pairs) {
    this.pairs = pairs;
  }

  public SavedResultCategory(CategoryDto category, List<PairDto> pairs) {
    this.category = category;
    this.pairs = pairs;
  }
}
