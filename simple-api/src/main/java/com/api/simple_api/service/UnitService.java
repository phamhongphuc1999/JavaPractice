package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.Unit;
import com.api.simple_api.repository.UnitRepository;

@Service
public class UnitService {
  @Autowired
  private UnitRepository unitRepository;


  public List<Unit> getByFilter(Unit filteredUnit) {
    return unitRepository.getByFilter(filteredUnit);
  }

  public Unit save(Unit entity) {
    Unit result = unitRepository.save(entity);
    return result;
  }
}
