package com.api.simple_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.UserDto;
import com.api.simple_api.entity.dto_utils.FilteredUser;
import com.api.simple_api.entity.dto_utils.ResultUser;
import com.api.simple_api.repository.UserRepository;

@Service
public class USerService {
  @Autowired
  private UserRepository userRepository;

  public List<ResultUser> getByFilter(FilteredUser filterUser) {
    return userRepository.getByFilter(filterUser);
  }

  public UserDto save(UserDto entity) {
    return userRepository.save(entity);
  }
}
