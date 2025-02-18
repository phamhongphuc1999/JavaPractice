package com.word.word.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.entity.common.PageableEntity;
import com.example.entity.common.PaginationResult;
import com.word.word.entity.dto.CategoryDto;
import com.word.word.entity.dto.PairDto;
import com.word.word.entity.dto_utils.FilteredCategory;
import com.word.word.entity.dto_utils.NewPair;
import com.word.word.entity.dto_utils.ResultCategory;
import com.word.word.entity.dto_utils.ReturnUpdatedCategory;
import com.word.word.entity.dto_utils.SavedResultCategory;
import com.word.word.entity.dto_utils.UpdatePair;
import com.word.word.entity.dto_utils.UpdatedCategory;
import com.word.word.repository.CategoryRepository;
import com.word.word.repository.PairRepository;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private PairRepository pairRepository;

  public PaginationResult<ResultCategory> getByFilter(FilteredCategory filteredCategory, PageableEntity pageable) {
    List<ResultCategory> items = categoryRepository.getByFilter(filteredCategory, pageable.getPageable());
    Integer total = categoryRepository.getTotalResultByFilter(filteredCategory);
    return new PaginationResult<>(total, items);
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

  public ReturnUpdatedCategory update(Integer userId, Integer categoryId, UpdatedCategory entity) {
    ReturnUpdatedCategory result = new ReturnUpdatedCategory();
    if (entity.getTitle() != null) {
      categoryRepository.updateCategory(userId, categoryId, entity.getTitle(), new Date());
      result.setTitle(entity.getTitle());
    }
    List<PairDto> newPairs = new ArrayList<>();
    if (entity.getNewPairs() != null) {
      for (NewPair newPair : entity.getNewPairs()) {
        newPairs.add(new PairDto(categoryId, newPair));
      }
    }
    if (newPairs.size() > 0) {
      List<PairDto> savedPairs = pairRepository.saveAll(newPairs);
      result.setNewPairs(savedPairs);
    }
    if (entity.getModifiedPairs() != null) {
      for (UpdatePair _pair : entity.getModifiedPairs()) {
        pairRepository.updatePair(_pair);
      }
    }
    if (entity.getRemovedIds() != null) {
      if (entity.getRemovedIds().size() > 0) {
        pairRepository.deleteAllByIdInBatch(entity.getRemovedIds());
        result.setRemovedIds(entity.getRemovedIds());
      }
    }
    return result;
  }

  public boolean delete(Integer userId, Integer categoryId) {
    try {
      FilteredCategory filteredCategory = new FilteredCategory(categoryId, null, userId);
      List<ResultCategory> categories = categoryRepository.getByFilter(filteredCategory, PageRequest.of(0, 10));
      if (categories.size() > 0) {
        pairRepository.deleteByCategoryId(userId, categoryId);
        categoryRepository.deleteById(categoryId);
      }
      return true;
    } catch (Exception exception) {
      return false;
    }
  }
}
