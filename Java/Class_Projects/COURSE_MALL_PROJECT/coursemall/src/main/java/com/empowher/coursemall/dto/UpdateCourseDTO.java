package com.empowher.coursemall.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UpdateCourseDTO extends CreateCourseDTO {
    @NotEmpty(message = "Enter the id")
    private String id;
}
