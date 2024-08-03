package com.api.simple_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
  @Query(value = "SELECT * FROM unit WHERE " +
  "IF :id IS NOT NULL id = :id AND " +
  "IF :display_name IS NOT NULL :display_name = display_name", 
  nativeQuery = true)
  public List<Unit> getByFilter(@Param("id") Optional<Long> id, @Param("display_name") Optional<String> displayName);
}
