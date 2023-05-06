package com.skillForgeAcademy.infrastructure.output.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rates")
@IdClass(RateId.class)
public class RateEntity {

    @Id
    @OneToOne
    private CourseEntity course;
    
    @Id
    @OneToOne
    private UserEntity user;

}
