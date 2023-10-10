package com.empowher.coursemall.controller;

import com.empowher.coursemall.dto.*;
import com.empowher.coursemall.dto.mapper.CourseMapper;
import com.empowher.coursemall.entity.Course;
import com.empowher.coursemall.repository.CourseRepository;
import com.empowher.coursemall.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseMallRestController {
    private CourseService courseService;
    private CourseRepository courseRepository;

    @GetMapping("")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(){
        List<CourseResponseDTO> courses = CourseMapper.toDTO(this.courseRepository.findAll());
        return ResponseEntity.ok(courses);
    }

    @PostMapping("")
    public ResponseEntity<CourseResponseDTO> createCourse(@Validated @RequestBody CreateCourseDTO createCourseDTO){
        CourseResponseDTO responseDTO = CourseMapper.toDTO(this.courseService.save(CourseMapper.toEntity(createCourseDTO)));
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable("id") String id) {
        CourseResponseDTO responseDTO = CourseMapper.toDTO(this.courseService.findById(id));
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("")
    public ResponseEntity<CourseResponseDTO> updateCourse(@RequestBody UpdateCourseDTO updateCourseDTO) {

        CourseResponseDTO responseDTO = CourseMapper.toDTO(this.courseService.update(updateCourseDTO.getId(), CourseMapper.toEntity(updateCourseDTO)));
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteCourse(@Validated @RequestBody DeleteCourseDTO deleteCourseDTO) {
       return new ResponseEntity<String>(this.courseService.deleteCourse(deleteCourseDTO.getId()), HttpStatus.OK);
    }

}
