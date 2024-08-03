package com.api.simple_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

}
