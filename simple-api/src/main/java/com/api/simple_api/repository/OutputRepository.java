package com.api.simple_api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Output;
import com.api.simple_api.entity.dto_utils.ResultOutput;

@Repository
public interface OutputRepository extends JpaRepository<Output, UUID> {
  @Query("SELECT new com.api.simple_api.entity.dto_utils.ResultOutput(op.id, oin.id, o.id, oin.customerId, op.outputDate, oin.count, oin.outputPrice, oin.status, o.displayName, u.displayName, cs.displayName) from Output op " +
  "LEFT JOIN OutputInfo oin ON op.id=oin.outputId " +
  "LEFT JOIN ObjectDto o ON oin.objectId=o.id " +
  "LEFT JOIN Unit u ON o.unit.id=u.id " +
  "LEFT JOIN Customer cs ON cs.id=oin.customerId")
  List<ResultOutput> getByFilter();
}
