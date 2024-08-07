package com.api.simple_api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Input;
import com.api.simple_api.entity.dto_utils.FilteredInput;
import com.api.simple_api.entity.dto_utils.ResultInput;

@Repository
public interface InputRepository extends JpaRepository<Input, UUID> {
  @Query("SELECT new com.api.simple_api.entity.dto_utils.ResultInput(i.id, ifn.id, ifn.objectId, i.inputDate, ifn.count, ifn.inputPrice, ifn.status, o.displayName, u.displayName) from Input i " +
  "LEFT JOIN InputInfo ifn ON i.id=ifn.inputId " +
  "LEFT JOIN ObjectDto o ON ifn.objectId=o.id " +
  "LEFT JOIN Unit u ON o.unit.id=u.id WHERE " +
  "(:#{#filteredInput.id} IS NULL OR i.id=:#{#filteredInput.id}) AND " + 
  "(:#{#filteredInput.infoId} IS NULL OR ifn.id=:#{#filteredInput.infoId}) AND " +
  "(:#{#filteredInput.objectId} IS NULL OR o.id=:#{#filteredInput.objectId}) AND " +
  "(:#{#filteredInput.fromInputDate} IS NULL OR :#{#filteredInput.fromInputDate} <= i.inputDate) AND " + 
  "(:#{#filteredInput.count} IS NULL OR ifn.count=:#{#filteredInput.count}) AND " + 
  "(:#{#filteredInput.inputPrice} IS NULL OR ifn.inputPrice=:#{#filteredInput.inputPrice}) AND " + 
  "(:#{#filteredInput.status} IS NULL OR ifn.status=:#{#filteredInput.status})")
  List<ResultInput> getByFilter(FilteredInput filteredInput);
}
