package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.User;
import com.api.simple_api.repository.UserRepository;

@Service
public class USerService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getByFilter() {
    return userRepository.getByFilter();
  }
}
