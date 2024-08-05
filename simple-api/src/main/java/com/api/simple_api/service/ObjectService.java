package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.ObjectDto;
import com.api.simple_api.entity.dto_utils.FilteredObjectDto;
import com.api.simple_api.repository.ObjectRepository;

@Service
public class ObjectService {
  @Autowired
  private ObjectRepository objectRepository;

  public List<ObjectDto> getByFilter(FilteredObjectDto filteredObject) {
    return objectRepository.getByFilter(filteredObject);
  }

  public void save(ObjectDto entity) {
    objectRepository.save(entity);
  }
}
