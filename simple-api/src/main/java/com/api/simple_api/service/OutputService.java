package com.api.simple_api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.simple_api.entity.dto.ObjectDto;
import com.api.simple_api.entity.dto.Output;
import com.api.simple_api.entity.dto.OutputInfo;
import com.api.simple_api.entity.dto_utils.FilteredOutput;
import com.api.simple_api.entity.dto_utils.NewOutput;
import com.api.simple_api.entity.dto_utils.ResultOutput;
import com.api.simple_api.repository.ObjectRepository;
import com.api.simple_api.repository.OutputInfoRepository;
import com.api.simple_api.repository.OutputRepository;

import jakarta.annotation.Nullable;

@Service
public class OutputService {
  @Autowired
  private OutputRepository outputRepository;

  @Autowired
  private OutputInfoRepository outputInfoRepository;

  @Autowired
  private ObjectRepository objectRepository;

  public List<ResultOutput> getByFilter(FilteredOutput filteredOutput) {
    return outputRepository.getByFilter(filteredOutput);
  }

  @SuppressWarnings("unused")
  public @Nullable Pair<Output, OutputInfo> save(NewOutput entity) {
    Optional<ObjectDto> testingObject = objectRepository.findById(entity.getObjectId());
    if (testingObject == null) 
      return null;
    if (testingObject.get().getCount() < entity.getCount())
      return null;
    Output newOutput = new Output(new Date());
    Output savedOutput = outputRepository.save(newOutput);
    OutputInfo newOutputInfo = new OutputInfo(entity, savedOutput.getId());
    OutputInfo savedOutputInfo = outputInfoRepository.save(newOutputInfo);
    objectRepository.decreaseCount(entity.getObjectId(), entity.getCount());
    return new Pair<Output,OutputInfo>(savedOutput, savedOutputInfo);
  }
}
