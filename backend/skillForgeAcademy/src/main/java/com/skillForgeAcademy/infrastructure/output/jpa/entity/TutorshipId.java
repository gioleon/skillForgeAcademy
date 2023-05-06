package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TutorshipId implements Serializable {
    private Long id;
    private SectionEntity section;
    private CourseEntity course;
}
