package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.Supplier;
import com.api.simple_api.entity.dto_utils.FilteredSupplier;
import com.api.simple_api.repository.SupplierRepository;

@Service
public class SupplierService {
  @Autowired
  private SupplierRepository supplierRepository;

  public List<Supplier> getByFilter(FilteredSupplier supplier) {
    return supplierRepository.getByFilter(supplier);
  }

  public Supplier save(Supplier entity) {
    Supplier result = supplierRepository.save(entity);
    return result;
  }
}
