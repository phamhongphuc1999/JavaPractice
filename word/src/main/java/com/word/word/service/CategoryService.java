package com.word.word.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.word.word.entity.dto.CategoryDto;
import com.word.word.entity.dto.PairDto;
import com.word.word.entity.dto_utils.FilteredCategory;
import com.word.word.entity.dto_utils.NewPair;
import com.word.word.entity.dto_utils.ResultCategory;
import com.word.word.entity.dto_utils.SavedResultCategory;
import com.word.word.repository.CategoryRepository;
import com.word.word.repository.PairRepository;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private PairRepository pairRepository;

  public List<ResultCategory> getByFilter(FilteredCategory filteredCategory) {
    return categoryRepository.getByFilter(filteredCategory);
  }

  public SavedResultCategory save(CategoryDto entity, List<NewPair> pairs) {
    CategoryDto savedCategory = categoryRepository.save(entity);
    List<PairDto> _pairs = new ArrayList<>();
    for (NewPair newPair : pairs) {
      _pairs.add(new PairDto(savedCategory.getId(), newPair));
    }
    List<PairDto> savedPairs = pairRepository.saveAll(_pairs);
    return new SavedResultCategory(savedCategory, savedPairs);
  }
}
