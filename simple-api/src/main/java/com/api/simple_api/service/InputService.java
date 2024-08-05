package com.api.simple_api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.Input;
import com.api.simple_api.entity.dto.InputInfo;
import com.api.simple_api.entity.dto_utils.NewInput;
import com.api.simple_api.repository.InputInfoRepository;
import com.api.simple_api.repository.InputRepository;

@Service
public class InputService {
  @Autowired
  private InputRepository inputRepository;

  @Autowired
  private InputInfoRepository inputInfoRepository;

  public void save(NewInput entity) {
    Input newInput = new Input(new Date());
    Input savedInput = inputRepository.save(newInput);
    InputInfo newInputInfo = new InputInfo(entity, savedInput.getId());
    inputInfoRepository.save(newInputInfo);
  }
}
