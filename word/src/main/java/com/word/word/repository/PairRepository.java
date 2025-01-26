package com.word.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.word.word.entity.dto.PairDto;

@Repository
public interface PairRepository extends JpaRepository<PairDto, Integer> {
  @Query("SELECT new com.word.word.entity.dto.PairDto(p.id, p.en, p.vi, p.categoryId) FROM PairDto p LEFT JOIN CategoryDto c ON c.id=:categoryId WHERE p.categoryId=:categoryId AND c.userId=:userId")
  List<PairDto> getByCategoryId(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId);
}
