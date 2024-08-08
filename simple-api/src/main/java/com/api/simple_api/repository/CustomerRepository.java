package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Customer;
import com.api.simple_api.entity.dto_utils.FilteredCustomer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  @Query("SELECT c FROM Customer c WHERE " +
  "(:#{#filteredCustomer.id} IS NULL OR c.id=:#{#filteredCustomer.id}) AND " + 
  "(:#{#filteredCustomer.displayName} IS NULL OR c.displayName LIKE :#{#filteredCustomer.displayName}) AND " +
  "(:#{#filteredCustomer.address} IS NULL OR c.address LIKE :#{#filteredCustomer.address}) AND " +
  "(:#{#filteredCustomer.phone} IS NULL OR c.phone LIKE :#{#filteredCustomer.phone}) AND " +
  "(:#{#filteredCustomer.email} IS NULL OR c.email LIKE :#{#filteredCustomer.email}) AND " +
  "(:#{#filteredCustomer.moreInfo} IS NULL OR c.moreInfo LIKE :#{#filteredCustomer.moreInfo}) AND " +
  "(:#{#filteredCustomer.fromContractDate} IS NULL OR c.contractDate >= :#{#filteredCustomer.fromContractDate}) AND " +
  "(:#{#filteredCustomer.toContractDate} IS NULL OR c.contractDate <= :#{#filteredCustomer.toContractDate})")
  List<Customer> getByFilter(@Param("filteredCustomer") FilteredCustomer filteredCustomer);
}
