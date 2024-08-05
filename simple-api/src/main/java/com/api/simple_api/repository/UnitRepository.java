package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
  @Query("SELECT u FROM Unit u WHERE " +
  "(:#{#filteredUnit.id} IS NULL OR u.id=:#{#filteredUnit.id}) AND " +
  "(:#{#filteredUnit.displayName} IS NULL OR u.displayName LIKE %:#{#filteredUnit.displayName}%)")
    List<Unit> getByFilter(@Param("filteredUnit") Unit filteredUnit);
}
