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
import com.word.word.entity.dto_utils.UpdatedCategory;
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

  public List<PairDto> getPairByCategoryId(Integer userId, Integer categoryId) {
    return pairRepository.getByCategoryId(userId, categoryId);
  }

  public SavedResultCategory save(CategoryDto entity, List<NewPair> pairs) {
    CategoryDto savedCategory = categoryRepository.save(entity);
    List<PairDto> _pairs = new ArrayList<>();
    for (NewPair newPair : pairs) {
      _pairs.add(new PairDto(savedCategory.getId(), newPair));
    }
    if (_pairs.size() > 0) {
      List<PairDto> savedPairs = pairRepository.saveAll(_pairs);
      return new SavedResultCategory(savedCategory, savedPairs);
    }
    return new SavedResultCategory(savedCategory, _pairs);
  }

  public List<PairDto> update(Integer userId, Integer categoryId, UpdatedCategory entity) {
    categoryRepository.updateCategory(userId, categoryId, entity.getTitle());
    List<PairDto> newPairs = new ArrayList<>();
    for (NewPair newPair : entity.getPairs()) {
      newPairs.add(new PairDto(categoryId, newPair));
    }
    if (newPairs.size() > 0) {
      List<PairDto> savedPairs = pairRepository.saveAll(newPairs);
      return savedPairs;
    }
    if (entity.getRemovedIds().size() > 0) {
      pairRepository.deleteAllByIdInBatch(entity.getRemovedIds());
    }
    return newPairs;
  }
}
