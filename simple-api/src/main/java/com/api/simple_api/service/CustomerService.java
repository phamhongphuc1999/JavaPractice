package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.Customer;
import com.api.simple_api.entity.dto_utils.FilteredCustomer;
import com.api.simple_api.repository.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getByFilter(FilteredCustomer filteredCustomer) {
    return customerRepository.getByFilter(filteredCustomer);
  }

  public Customer save(Customer entity) {
    return customerRepository.save(entity);
  }
}
