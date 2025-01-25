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
      "(:#{#filteredUser.id} IS NULL OR u.id=:#{#filteredUser.id}) AND " +
      "(:#{#filteredUser.displayName} IS NULL OR u.displayName LIKE :#{#filteredUser.displayName}) AND " +
      "(:#{#filteredUser.username} IS NULL OR u.username LIKE :#{#filteredUser.username}) AND " +
      "(:#{#filteredUser.password} IS NULL OR u.password LIKE :#{#filteredUser.password})")
  List<ResultUser> getByFilter(@Param("filteredUser") FilteredUser filteredUser);
}