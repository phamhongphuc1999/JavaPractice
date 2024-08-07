package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.UserRole;
import com.api.simple_api.repository.UserRoleRepository;

@Service
public class UserRoleService {
  @Autowired
  private UserRoleRepository userRoleRepository;

  public List<UserRole> getByFilter() {
    return userRoleRepository.getByFilter();
  }
}
