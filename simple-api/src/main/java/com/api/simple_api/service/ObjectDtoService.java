package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.common.PageableEntity;
import com.api.simple_api.entity.common.PaginationResult;
import com.api.simple_api.entity.dto.ObjectDto;
import com.api.simple_api.entity.dto_utils.FilteredObjectDto;
import com.api.simple_api.repository.ObjectRepository;

@Service
public class ObjectDtoService {
  @Autowired
  private ObjectRepository objectRepository;

  public PaginationResult<ObjectDto> getByFilter(FilteredObjectDto filteredObject, PageableEntity pageable) {
    Integer total = objectRepository.getTotalResultByFilter(filteredObject);
    List<ObjectDto> items = objectRepository.getByFilter(filteredObject, pageable.getPageable());
    return new PaginationResult<>(total, items);
  }

  public ObjectDto save(ObjectDto entity) {
    ObjectDto result = objectRepository.save(entity);
    return result;
  }
}
