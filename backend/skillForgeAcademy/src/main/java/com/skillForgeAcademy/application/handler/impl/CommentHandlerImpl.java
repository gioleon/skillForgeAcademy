package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.CommentRequestDto;
import com.skillForgeAcademy.application.dto.request.CommentRequestIdDto;
import com.skillForgeAcademy.application.dto.response.CommentResponseDto;
import com.skillForgeAcademy.application.handler.ICommentHandler;
import com.skillForgeAcademy.application.mapper.request.ICommentRequestIdMapper;
import com.skillForgeAcademy.application.mapper.request.ICommentRequestMapper;
import com.skillForgeAcademy.application.mapper.response.ICommentResponseMapper;
import com.skillForgeAcademy.domain.api.ICommentServicePort;
import com.skillForgeAcademy.domain.model.CommentModelId;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentHandlerImpl implements ICommentHandler {
  private final ICommentServicePort commentServicePort;
  private final ICommentResponseMapper commentResponseMapper;
  private final ICommentRequestMapper commentRequestMapper;
  private final ICommentRequestIdMapper commentRequestIdMapper;

  @Override
  public void create(CommentRequestDto commentRequestDto) {
    commentServicePort.create(commentRequestMapper.toModel(commentRequestDto));
  }

  @Override
  public CommentResponseDto find(CommentRequestIdDto commentRequestIdDto) {
    CommentModelId commentModelId = commentRequestIdMapper.toModel(commentRequestIdDto);
    return commentResponseMapper.toResponse(commentServicePort.find(commentModelId));
  }

  @Override
  public CommentResponseDto delete(CommentRequestIdDto commentRequestIdDto) {
    CommentModelId commentModelId = commentRequestIdMapper.toModel(commentRequestIdDto);
    return commentResponseMapper.toResponse(commentServicePort.delete(commentModelId));
  }

  @Override
  public List<CommentResponseDto> findAll() {
    return commentResponseMapper.toResponseList(commentServicePort.findAll());
  }
}
