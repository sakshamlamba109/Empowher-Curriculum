package com.empowher.coursemall.service;

import com.empowher.coursemall.entity.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.empowher.coursemall.repository.AuthorRepository;
import com.empowher.coursemall.repository.CourseRepository;

@Service
@AllArgsConstructor
public class CourseService {

    private AuthorRepository authorRepository;
    private CourseRepository courseRepository;

    public Course findById(String id) {
        return this.courseRepository.findById(id).orElseThrow();
    }

    public Course save(Course course) {
        this.courseRepository.save(course);
        this.authorRepository.save(course.getAuthor());
        return course;
    }

    public Course update(String id, Course course) {
        Course courseDatabase = this.findById(id);
        BeanUtils.copyProperties(course, courseDatabase, "id", "createdAt", "updatedAt", "author");
        BeanUtils.copyProperties(course.getAuthor(), courseDatabase.getAuthor(), "id", "createdAt", "updatedAt", "course");
        return this.courseRepository.save(courseDatabase);
    }

    public String deleteCourse(String id) {
        Course foundCourse = this.findById(id);
        if(foundCourse == null){
            return "Course with id: "+id+" is not found and Couldn't be deleted" ;
        }else{
            this.courseRepository.delete(foundCourse);
            return "Course with id: "+id+" deleted successfully" ;
        }
    }

}
