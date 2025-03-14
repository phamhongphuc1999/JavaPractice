package com.word.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.word.word.entity.dto.PairDto;

import jakarta.transaction.Transactional;

@Repository
public interface PairRepository extends JpaRepository<PairDto, Integer> {
  @Query("SELECT new com.word.word.entity.dto.PairDto(p.id, p.en, p.vi, p.categoryId) FROM PairDto p LEFT JOIN CategoryDto c ON c.id=:categoryId WHERE p.categoryId=:categoryId AND c.userId=:userId")
  List<PairDto> getByCategoryId(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId);

  @Modifying
  @Transactional
  @Query(value = "UPDATE pair p SET p.en = CASE WHEN :en IS NOT NULL THEN :en ELSE p.en END, p.vi = CASE WHEN :vi IS NOT NULL THEN :vi ELSE p.vi END WHERE p.id=:id", nativeQuery = true)
  void updatePair(@Param("en") String en, @Param("vi") String vi, @Param("id") Integer id);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM pair \n" + //
      "WHERE category_id = :categoryId \n" + //
      "AND category_id IN (SELECT id FROM category WHERE id = :categoryId AND user_id = :userId)", nativeQuery = true)
  void deleteByCategoryId(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId);
}
