package com.api.simple_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.UserDto;
import com.api.simple_api.entity.dto_utils.FilteredUser;
import com.api.simple_api.entity.dto_utils.ResultUser;
import com.api.simple_api.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if ("javainuse".equals(username)) {
      return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
          new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }

  public List<ResultUser> getByFilter(FilteredUser filterUser) {
    return userRepository.getByFilter(filterUser);
  }

  public UserDto save(UserDto entity) {
    return userRepository.save(entity);
  }
}
