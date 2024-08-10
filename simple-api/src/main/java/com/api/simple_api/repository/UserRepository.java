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
public interface UserRepository extends JpaRepository<UserDto, Long> {
  @Query("SELECT new com.api.simple_api.entity.dto_utils.ResultUser(u.id, u.displayName, u.username, u.password, u.roleId, ur.displayName) FROM UserDto u LEFT JOIN UserRole ur ON ur.id=u.roleId WHERE " +
  "(:#{#filterUser.id} IS NULL OR u.id=:#{#filterUser.id}) AND " +
  "(:#{#filterUser.displayName} IS NULL OR u.displayName LIKE :#{#filterUser.displayName}) AND " +
  "(:#{#filterUser.username} IS NULL OR u.username LIKE :#{#filterUser.username}) AND " +
  "(:#{#filterUser.password} IS NULL OR u.password LIKE :#{#filterUser.password}) AND " +
  "(:#{#filterUser.roleId} IS NULL OR u.roleId=:#{#filterUser.roleId})")
  List<ResultUser> getByFilter(@Param("filterUser") FilteredUser filterUser);
}
