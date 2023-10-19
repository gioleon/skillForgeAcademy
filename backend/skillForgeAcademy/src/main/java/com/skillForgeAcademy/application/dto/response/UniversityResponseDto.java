package com.skillForgeAcademy.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniversityResponseDto {
    private Long id;
    private String name;
    private String emailDomain;
}
