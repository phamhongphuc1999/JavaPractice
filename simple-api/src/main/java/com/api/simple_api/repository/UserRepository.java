package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.UserDto;
import com.api.simple_api.entity.dto_utils.FilteredUser;
import com.api.simple_api.entity.dto_utils.ResultUser;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {
  @Query("SELECT new com.api.simple_api.entity.dto_utils.ResultUser(u.id, u.displayName, u.username, u.password, u.roleId, ur.displayName) FROM UserDto u LEFT JOIN UserRole ur ON ur.id=u.roleId WHERE "
      +
      "(:#{#filteredUser.id} IS NULL OR u.id=:#{#filteredUser.id}) AND " +
      "(:#{#filteredUser.displayName} IS NULL OR u.displayName LIKE :#{#filteredUser.displayName}) AND " +
      "(:#{#filteredUser.username} IS NULL OR u.username LIKE :#{#filteredUser.username}) AND " +
      "(:#{#filteredUser.password} IS NULL OR u.password LIKE :#{#filteredUser.password}) AND " +
      "(:#{#filteredUser.roleId} IS NULL OR u.roleId=:#{#filteredUser.roleId})")
  List<ResultUser> getByFilter(@Param("filteredUser") FilteredUser filteredUser);
}
