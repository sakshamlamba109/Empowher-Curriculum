package com.empowher.coursemall.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CreateCourseDTO {
    @NotEmpty(message = "Enter the name")
	private String name;
    @NotEmpty(message = "Enter the course link")
	private String link;
    @NotEmpty(message = "Enter the course category")
    private String category;
    @NotEmpty(message = "Enter the author's name")
    private String author;
    @NotEmpty(message = "Enter the author's highest degree")
    private String degree;
    @Email
    @NotEmpty(message = "Enter the author's email")
    private String email;
}
