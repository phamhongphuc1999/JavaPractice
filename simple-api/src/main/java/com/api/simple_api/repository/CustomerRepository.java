package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<Customer> getByFilter();
}
