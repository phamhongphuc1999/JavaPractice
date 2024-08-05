package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
  @Query("SELECT u FROM Unit u WHERE (1=1) AND (:id IS NOT NULL AND u.id=:id) OR (u.displayName LIKE :displayName)")
    List<Unit> findByFilter(@Param("id") Long id, @Param("displayName") String displayName);
}
