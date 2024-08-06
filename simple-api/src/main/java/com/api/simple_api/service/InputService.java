package com.api.simple_api.service;

import java.util.Date;
import java.util.List;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.Input;
import com.api.simple_api.entity.dto.InputInfo;
import com.api.simple_api.entity.dto_utils.FilteredInput;
import com.api.simple_api.entity.dto_utils.NewInput;
import com.api.simple_api.entity.dto_utils.ResultInput;
import com.api.simple_api.repository.InputInfoRepository;
import com.api.simple_api.repository.InputRepository;

@Service
public class InputService {
  @Autowired
  private InputRepository inputRepository;

  @Autowired
  private InputInfoRepository inputInfoRepository;

  public List<ResultInput> getByFilter(FilteredInput filteredInput) {
    return inputRepository.getByFilter(filteredInput);
  }

  public Pair<Input, InputInfo> save(NewInput entity) {
    Input newInput = new Input(new Date());
    Input savedInput = inputRepository.save(newInput);
    InputInfo newInputInfo = new InputInfo(entity, savedInput.getId());
    InputInfo savedInputInfo = inputInfoRepository.save(newInputInfo);
    return new Pair<Input,InputInfo>(savedInput, savedInputInfo);
  }
}
