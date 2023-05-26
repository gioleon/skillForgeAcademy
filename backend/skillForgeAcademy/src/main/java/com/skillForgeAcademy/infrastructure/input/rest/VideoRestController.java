package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.TutorshipRequestDto;
import com.skillForgeAcademy.application.dto.request.VideoRequestDto;
import com.skillForgeAcademy.application.dto.request.VideoRequestIdDto;
import com.skillForgeAcademy.application.dto.response.VideoResponseDto;
import com.skillForgeAcademy.application.handler.IVideoHandler;
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
@RequestMapping("/api/video")
@RequiredArgsConstructor
public class VideoRestController {
  private final IVideoHandler videoHandler;

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody VideoRequestDto videoRequestDto) {
    videoHandler.create(videoRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<VideoResponseDto>> findAll() {
    return ResponseEntity.ok(videoHandler.findAll());
  }

  @GetMapping("/{idTutorship}/{idVideo}")
  public ResponseEntity<VideoResponseDto> findById(
      @PathVariable String idTutorship, @PathVariable String idVideo) {

    TutorshipRequestDto tutorshipRequestDto = new TutorshipRequestDto();
    VideoRequestIdDto videoRequestIdDto = new VideoRequestIdDto();

    tutorshipRequestDto.setId(idTutorship);

    videoRequestIdDto.setId(idVideo);
    videoRequestIdDto.setTutorship(tutorshipRequestDto);

    return ResponseEntity.ok(videoHandler.find(videoRequestIdDto));
  }

  @GetMapping("/delete/{idTutorship}/{idVideo}")
  public ResponseEntity<VideoResponseDto> deleteById(
      @PathVariable String idTutorship, @PathVariable String idVideo) {

    TutorshipRequestDto tutorshipRequestDto = new TutorshipRequestDto();
    VideoRequestIdDto videoRequestIdDto = new VideoRequestIdDto();

    tutorshipRequestDto.setId(idTutorship);

    videoRequestIdDto.setId(idVideo);
    videoRequestIdDto.setTutorship(tutorshipRequestDto);

    return ResponseEntity.ok(videoHandler.delete(videoRequestIdDto));
  }
}
