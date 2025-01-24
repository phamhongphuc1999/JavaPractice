package com.word.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.word.word.entity.dto.CategoryDto;
import com.word.word.entity.dto_utils.FilteredCategory;
import com.word.word.entity.dto_utils.ResultUser;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDto, Integer> {
  @Query("SELECT new com.word.word.entity.dto_utils.ResultCategory(c.id, c.title, c.userId, u.displayName, u.username) FROM CategoryDto c LEFT JOIN UserDto u ON u.id=c.userId WHERE "
      + "(:#{#filteredCategory.id} IS NULL OR c.id=:#{#filteredCategory.id}) AND " +
      "(:#{#filteredCategory.title} IS NULL OR c.title LIKE :#{#filteredCategory.title}) AND " +
      "(:#{#filteredCategory.userId} IS NULL OR c.userId=:#{#filteredCategory.userId})")
  List<ResultUser> getByFilter(@Param("filteredCategory") FilteredCategory filterUser);
}
