package com.word.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.word.word.entity.dto.PairDto;

@Repository
public interface PairRepository extends JpaRepository<PairDto, Integer> {

}
