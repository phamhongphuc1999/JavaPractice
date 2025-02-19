package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.common.PageableEntity;
import com.api.simple_api.entity.common.PaginationResult;
import com.api.simple_api.entity.dto.Unit;
import com.api.simple_api.repository.UnitRepository;

@Service
public class UnitService {
  @Autowired
  private UnitRepository unitRepository;

  public PaginationResult<Unit> getByFilter(Unit filteredUnit, PageableEntity pageable) {
    Integer total = unitRepository.getTotalResultByFilter(filteredUnit);
    List<Unit> items = unitRepository.getByFilter(filteredUnit, pageable.getPageable());
    return new PaginationResult<>(total, items);
  }

  public Unit save(Unit entity) {
    Unit result = unitRepository.save(entity);
    return result;
  }
}
