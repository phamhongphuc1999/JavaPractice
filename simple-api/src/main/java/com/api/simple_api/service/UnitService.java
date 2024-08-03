package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.Unit;
import com.api.simple_api.repository.UnitRepository;

@Service
public class UnitService {
  @Autowired
  private UnitRepository uintRepository;

  public List<Unit> getAll() {
    return uintRepository.findAll();
  }
}
