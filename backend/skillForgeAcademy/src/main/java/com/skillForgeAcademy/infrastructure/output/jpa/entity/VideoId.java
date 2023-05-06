package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VideoId implements Serializable {
    private long id;
    private TutorshipEntity tutorship;
}
