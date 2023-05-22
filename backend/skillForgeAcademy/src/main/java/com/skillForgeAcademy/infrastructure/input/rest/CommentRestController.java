package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.CommentRequestDto;
import com.skillForgeAcademy.application.dto.request.CommentRequestIdDto;
import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.CommentResponseDto;
import com.skillForgeAcademy.application.handler.ICommentHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentRestController {
  private final ICommentHandler commentHandler;

  @PostMapping()
  public ResponseEntity<Void> create(@RequestBody CommentRequestDto commentRequestDto) {
    commentHandler.create(commentRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<CommentResponseDto>> findAll() {
    return ResponseEntity.ok(commentHandler.findAll());
  }

  @GetMapping("/{idUser}/{idCourse}/{idComment}")
  public ResponseEntity<CommentResponseDto> findById(
      @PathVariable long idUser, @PathVariable long idCourse, @PathVariable String idComment) {
    CommentRequestIdDto commentRequestIdDto = new CommentRequestIdDto();
    UserRequestDto userRequestDto = new UserRequestDto();
    CourseRequestDto courseRequestDto = new CourseRequestDto();

    userRequestDto.setId(idUser);
    courseRequestDto.setId(idCourse);

    commentRequestIdDto.setId(idComment);
    commentRequestIdDto.setUser(userRequestDto);
    commentRequestIdDto.setCourse(courseRequestDto);

    return ResponseEntity.ok(commentHandler.find(commentRequestIdDto));
  }

  @GetMapping("/delete/{idUser}/{idCourse}/{idComment}")
  public ResponseEntity<CommentResponseDto> deleteById(
      @PathVariable long idUser, @PathVariable long idCourse, @PathVariable String idComment) {
    CommentRequestIdDto commentRequestIdDto = new CommentRequestIdDto();
    UserRequestDto userRequestDto = new UserRequestDto();
    CourseRequestDto courseRequestDto = new CourseRequestDto();

    userRequestDto.setId(idUser);
    courseRequestDto.setId(idCourse);

    commentRequestIdDto.setId(idComment);
    commentRequestIdDto.setUser(userRequestDto);
    commentRequestIdDto.setCourse(courseRequestDto);

    return ResponseEntity.ok(commentHandler.delete(commentRequestIdDto));
  }
}
