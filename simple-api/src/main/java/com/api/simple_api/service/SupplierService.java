package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.common.PageableEntity;
import com.api.simple_api.entity.common.PaginationResult;
import com.api.simple_api.entity.dto.Supplier;
import com.api.simple_api.entity.dto_utils.FilteredSupplier;
import com.api.simple_api.repository.SupplierRepository;

@Service
public class SupplierService {
  @Autowired
  private SupplierRepository supplierRepository;

  public PaginationResult<Supplier> getByFilter(FilteredSupplier filteredSupplier, PageableEntity pageable) {
    Integer total = supplierRepository.getTotalResultByFilter(filteredSupplier);
    List<Supplier> items = supplierRepository.getByFilter(filteredSupplier, pageable.getPageable());
    return new PaginationResult<>(total, items);
  }

  public Supplier save(Supplier entity) {
    Supplier result = supplierRepository.save(entity);
    return result;
  }
}
