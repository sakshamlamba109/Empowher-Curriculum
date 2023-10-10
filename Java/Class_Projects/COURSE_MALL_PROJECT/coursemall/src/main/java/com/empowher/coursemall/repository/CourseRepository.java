package com.empowher.coursemall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empowher.coursemall.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,String>{
	
}

