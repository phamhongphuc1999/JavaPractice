package com.word.word.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.word.word.entity.dto.UserDto;
import com.word.word.entity.dto_utils.FilteredUser;
import com.word.word.entity.dto_utils.ResultUser;
import com.word.word.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public ResultUser getByUsername(String username) {
    FilteredUser filteredUser = new FilteredUser(null, null, username, null);
    List<ResultUser> users = userRepository.getByFilter(filteredUser);
    if (users != null) {
      ResultUser user = users.get(0);
      return user;
    }
    return null;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    ResultUser user = this.getByUsername(username);
    if (user != null) {
      return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with username: " +
          username);
    }
  }

  public List<ResultUser> getByFilter(FilteredUser filteredUser) {
    return userRepository.getByFilter(filteredUser);
  }

  public UserDto save(UserDto entity) {
    String encodedPassword = passwordEncoder.encode(entity.getPassword());
    UserDto savedUser = new UserDto(entity.getId(), entity.getDisplayName(), entity.getUsername(), encodedPassword);
    return userRepository.save(savedUser);
  }

  public boolean deleteUser(Integer id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception exception) {
      return false;
    }
  }
}
