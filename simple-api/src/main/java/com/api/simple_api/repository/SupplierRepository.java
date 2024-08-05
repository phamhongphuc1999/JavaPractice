package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Supplier;
import com.api.simple_api.entity.dto_utils.FilteredSupplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
  @Query("SELECT s FROM Supplier s WHERE " +
  "(:#{#filteredSupplier.id} IS NULL OR s.id=:#{#filteredSupplier.id}) AND " +
  "(:#{#filteredSupplier.displayName} IS NULL OR s.displayName LIKE %:#{#filteredSupplier.displayName}%) AND " +
  "(:#{#filteredSupplier.address} IS NULL OR s.address LIKE %:#{#filteredSupplier.address}%) AND " +
  "(:#{#filteredSupplier.phone} IS NULL OR s.phone LIKE %:#{#filteredSupplier.phone}%) AND " +
  "(:#{#filteredSupplier.email} IS NULL OR s.email LIKE %:#{#filteredSupplier.email}%) AND " +
  "(:#{#filteredSupplier.moreInfo} IS NULL OR s.moreInfo LIKE %:#{#filteredSupplier.moreInfo}%) AND " +
  "(:#{#filteredSupplier.fromContractDate} IS NULL OR s.contractDate >= :#{#filteredSupplier.fromContractDate}) AND " +
  "(:#{#filteredSupplier.toContractDate} IS NULL OR s.contractDate <= :#{#filteredSupplier.toContractDate})")
  List<Supplier> getByFilter(@Param("filteredSupplier") FilteredSupplier filteredSupplier);
}
