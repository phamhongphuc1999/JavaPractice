package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
  @Query("SELECT ur FROM UserRole ur WHERE " +
  "(:id IS NULL OR ur.id=:id) AND " +
  "(:displayName IS NULL OR ur.displayName LIKE :displayName)")
  List<UserRole> getByFilter(@Param("id") Long id, @Param("displayName") String displayName);
}
