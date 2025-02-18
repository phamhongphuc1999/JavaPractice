package com.word.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.word.word.entity.dto.PairDto;
import com.word.word.entity.dto_utils.UpdatePair;

import jakarta.transaction.Transactional;

@Repository
public interface PairRepository extends JpaRepository<PairDto, Integer> {
  @Query("SELECT new com.word.word.entity.dto.PairDto(p.id, p.en, p.vi, p.categoryId) FROM PairDto p LEFT JOIN CategoryDto c ON c.id=:categoryId WHERE p.categoryId=:categoryId AND c.userId=:userId")
  List<PairDto> getByCategoryId(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId);

  @Modifying
  @Transactional
  @Query(value = "UPDATE pair p SET (:updatePair.en IS NULL OR p.en=:updatePair.en) AND (:updatePair.vi IS NULL OR p.vi=:updatePair.vi) WHERE p.id=:updatePair.id", nativeQuery = true)
  void updatePair(@Param("updatePair") UpdatePair updatePair);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM pair p LEFT JOIN category c ON c.id=:categoryId WHERE p.categoryId=:categoryId AND c.userId=:userId", nativeQuery = true)
  void deleteByCategoryId(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId);
}
