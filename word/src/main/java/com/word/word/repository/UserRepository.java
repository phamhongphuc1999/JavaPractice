package com.word.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.word.word.entity.dto.UserDto;
import com.word.word.entity.dto_utils.FilteredUser;
import com.word.word.entity.dto_utils.ResultUser;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {
  @Query("SELECT new com.word.word.entity.dto_utils.ResultUser(u.id, u.displayName, u.username, u.password) FROM UserDto u WHERE "
      +
      "(:#{#filterUser.id} IS NULL OR u.id=:#{#filterUser.id}) AND " +
      "(:#{#filterUser.displayName} IS NULL OR u.displayName LIKE :#{#filterUser.displayName}) AND " +
      "(:#{#filterUser.username} IS NULL OR u.username LIKE :#{#filterUser.username}) AND " +
      "(:#{#filterUser.password} IS NULL OR u.password LIKE :#{#filterUser.password})")
  List<ResultUser> getByFilter(@Param("filterUser") FilteredUser filterUser);
}