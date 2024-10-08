package com.api.simple_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.InputInfo;

@Repository
public interface InputInfoRepository extends JpaRepository<InputInfo, UUID> {

}
