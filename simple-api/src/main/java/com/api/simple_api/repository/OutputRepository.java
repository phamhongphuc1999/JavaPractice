package com.api.simple_api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Output;
import com.api.simple_api.entity.dto_utils.FilteredOutput;
import com.api.simple_api.entity.dto_utils.ResultOutput;

@Repository
public interface OutputRepository extends JpaRepository<Output, UUID> {
  @Query("SELECT new com.api.simple_api.entity.dto_utils.ResultOutput(op.id, oin.id, o.id, oin.customerId, op.outputDate, oin.count, oin.outputPrice, oin.status, o.displayName, u.displayName, cs.displayName, s.displayName) from Output op " +
  "LEFT JOIN OutputInfo oin ON op.id=oin.outputId " +
  "LEFT JOIN ObjectDto o ON oin.objectId=o.id " +
  "LEFT JOIN Unit u ON o.unit.id=u.id " +
  "LEFT JOIN Supplier s ON s.id=o.supplier.id " +
  "LEFT JOIN Customer cs ON cs.id=oin.customerId WHERE " +
  "(:#{#filteredOutput.id} IS NULL OR op.id=:#{#filteredOutput.id}) AND " + 
  "(:#{#filteredOutput.infoId} IS NULL OR oin.id=:#{#filteredOutput.infoId}) AND " +
  "(:#{#filteredOutput.objectId} IS NULL OR o.id=:#{#filteredOutput.objectId}) AND " + 
  "(:#{#filteredOutput.customerId} IS NULL OR cs.id=:#{#filteredOutput.customerId}) AND " + 
  "(:#{#filteredOutput.fromOutputDate} IS NULL OR op.outputDate>=:#{#filteredOutput.fromOutputDate}) AND " +
  "(:#{#filteredOutput.toOutputDate} IS NULL OR op.outputDate<=:#{#filteredOutput.toOutputDate}) AND " +
  "(:#{#filteredOutput.count} IS NULL OR oin.count=:#{#filteredOutput.count}) AND " +
  "(:#{#filteredOutput.fromOutputPrice} IS NULL OR oin.outputPrice>=:#{#filteredOutput.fromOutputPrice}) AND " +
  "(:#{#filteredOutput.toOutputPrice} IS NULL OR oin.outputPrice>=:#{#filteredOutput.toOutputPrice}) AND " +
  "(:#{#filteredOutput.status} IS NULL OR oin.status=:#{#filteredOutput.status}) AND " +
  "(:#{#filteredOutput.objectName} IS NULL OR o.displayName LIKE :#{#filteredOutput.objectName}) AND " +
  "(:#{#filteredOutput.unitName} IS NULL OR u.displayName LIKE :#{#filteredOutput.unitName}) AND " +
  "(:#{#filteredOutput.customerName} IS NULL OR cs.displayName LIKE :#{#filteredOutput.customerName})")
  List<ResultOutput> getByFilter(@Param("filteredOutput") FilteredOutput filteredOutput);
}
