package com.api.simple_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.Unit;
import com.api.simple_api.repository.UnitRepository;

@Service
public class UnitService {
  private final UnitRepository unitRepository;

  @Autowired
  public UnitService(UnitRepository unitRepository) {
    this.unitRepository = unitRepository;
  }

  public List<Unit> getAll(Optional<Long> id, Optional<String> displayName) {
    return unitRepository.getByFilter(id, displayName);
  }

  public Optional<Unit> getById(Long id) {
    return unitRepository.findById(id);
  }

  public void save(Unit entity) {
    unitRepository.save(entity);
  }
}
