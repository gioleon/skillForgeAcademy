package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.CommentRequestDto;
import com.skillForgeAcademy.application.dto.request.CommentRequestIdDto;
import com.skillForgeAcademy.application.dto.response.CommentResponseDto;
import java.util.List;

public interface ICommentHandler {
    void create(CommentRequestDto commentRequestDto);
    CommentResponseDto find(CommentRequestIdDto commentRequestIdDto);
    CommentResponseDto delete(CommentRequestIdDto commentRequestIdDto);
    List<CommentResponseDto> findAll();
}
