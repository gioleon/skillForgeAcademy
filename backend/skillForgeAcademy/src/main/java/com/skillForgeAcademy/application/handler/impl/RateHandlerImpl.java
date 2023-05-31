package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.RateRequestDto;
import com.skillForgeAcademy.application.dto.request.RateRequestIdDto;
import com.skillForgeAcademy.application.dto.response.RateResponseDto;
import com.skillForgeAcademy.application.handler.IRateHandler;
import com.skillForgeAcademy.application.mapper.request.IRateRequestIdMapper;
import com.skillForgeAcademy.application.mapper.request.IRateRequestMapper;
import com.skillForgeAcademy.application.mapper.response.IRateResponseMapper;
import com.skillForgeAcademy.domain.api.IRateServicePort;
import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.model.RateModelId;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class RateHandlerImpl implements IRateHandler {

  private final IRateServicePort rateServicePort;
  private final IRateRequestMapper rateRequestMapper;
  private final IRateRequestIdMapper rateRequestIdMapper;
  private final IRateResponseMapper rateResponseMapper;

  @Override
  public void create(RateRequestDto rateRequestDto) {
    rateServicePort.create(rateRequestMapper.toModel(rateRequestDto));
  }

  @Override
  public RateResponseDto find(RateRequestIdDto rateRequestIdDto) {
    RateModelId rateModelId = rateRequestIdMapper.toModel(rateRequestIdDto);
    return rateResponseMapper.toResponse(rateServicePort.find(rateModelId));
  }

  @Override
  public RateResponseDto delete(RateRequestIdDto rateRequestIdDto) {
    RateModelId rateModelId = rateRequestIdMapper.toModel(rateRequestIdDto);
    return rateResponseMapper.toResponse(rateServicePort.delete(rateModelId));
  }

  @Override
  public List<RateResponseDto> findAll() {
    return rateResponseMapper.toResponseList(rateServicePort.findAll());
  }

  @Override
  public List<RateResponseDto> findByCourse(Long id) {
    return rateResponseMapper.toResponseList(rateServicePort.findByCourse(id));
  }
}
