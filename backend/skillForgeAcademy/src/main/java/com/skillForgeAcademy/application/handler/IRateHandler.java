package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.RateRequestDto;
import com.skillForgeAcademy.application.dto.request.RateRequestIdDto;
import com.skillForgeAcademy.application.dto.response.RateResponseDto;
import java.util.List;

public interface IRateHandler {
    void create(RateRequestDto rateRequestDto);
    RateResponseDto find(RateRequestIdDto rateRequestIdDto);
    RateResponseDto delete(RateRequestIdDto rateResponseIdDto);
    List<RateResponseDto> findAll();
    List<RateResponseDto> findByCourse(Long id);
}
