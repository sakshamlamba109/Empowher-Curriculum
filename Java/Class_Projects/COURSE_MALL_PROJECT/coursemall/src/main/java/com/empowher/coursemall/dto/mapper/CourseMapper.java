package com.empowher.coursemall.dto.mapper;

import com.empowher.coursemall.dto.UpdateCourseDTO;
import com.empowher.coursemall.entity.Course;
import com.empowher.coursemall.entity.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import com.empowher.coursemall.dto.CreateCourseDTO;
import com.empowher.coursemall.dto.CourseResponseDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseMapper {

    public static Course toEntity(CreateCourseDTO dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setLink(dto.getLink());
        course.setCategory(dto.getCategory());
        Author author = new Author();
        author.setName(dto.getAuthor());
        author.setEmail(dto.getEmail());
        author.setDegree(dto.getDegree());
        author.setCourse(course);
        course.setAuthor(author);
        return course;
    }
    public static Course toEntity(UpdateCourseDTO dto) {
        CreateCourseDTO createDto = dto;
        Course course = toEntity(createDto);
        course.setId(dto.getId());
        return course;
    }

    public static CourseResponseDTO toDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setLink(course.getLink());
        dto.setCategory(course.getCategory());
        dto.setCreatedAt(course.getCreatedAt());

        dto.setAuthor(course.getAuthor().getName());
        dto.setEmail(course.getAuthor().getEmail());
        dto.setDegree(course.getAuthor().getDegree());

        return dto;
    }

    public static List<CourseResponseDTO> toDTO(List<Course> courses) {
        return courses.stream()
                .map(course -> toDTO(course))
                .collect(Collectors.toList());
    }

}
