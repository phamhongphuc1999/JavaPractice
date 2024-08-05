package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.ObjectDto;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectDto, Long> {
  List<ObjectDto> getByFilter(@Param("filteredObject") ObjectDto filteredObject);
}
