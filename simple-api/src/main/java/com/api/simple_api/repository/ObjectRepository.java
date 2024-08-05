package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.ObjectDto;
import com.api.simple_api.entity.dto_utils.FilteredObjectDto;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectDto, Long> {
  @Query("SELECT o FROM ObjectDto o " +
  "LEFT JOIN Unit u ON o.unit.id=u.id LEFT JOIN Supplier s ON o.supplier.id=s.id WHERE " +
  "(:#{#filteredObject.id} IS NULL OR o.id=:#{#filteredObject.id}) AND " +
  "(:#{#filteredObject.displayName} IS NULL OR o.displayName LIKE %:#{#filteredObject.displayName}%) AND " +
  "(:#{#filteredObject.unitId} IS NULL OR o.unit.id=:#{#filteredObject.unitId}) AND " +
  "(:#{#filteredObject.supplierId} IS NULL OR o.supplier.id=:#{#filteredObject.supplierId}) AND " + 
  "(:#{#filteredObject.qrCode} IS NULL OR o.qrCode LIKE %:#{#filteredObject.qrCode}%) AND " + 
  "(:#{#filteredObject.barCode} IS NULL OR o.barCode LIKE %:#{#filteredObject.barCode}%)")
  List<ObjectDto> getByFilter(@Param("filteredObject") FilteredObjectDto filteredObject);
}
