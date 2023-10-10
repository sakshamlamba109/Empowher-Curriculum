package com.empowher.coursemall.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponseDTO {
    private String id;
    private String name;
    private String category;
    private String link;
    private LocalDateTime createdAt;
    private String author;
    private String degree;
    private String email;
}
