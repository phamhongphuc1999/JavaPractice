package com.api.simple_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.simple_api.entity.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> getByFilter();
}
