package com.empowher.coursemall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empowher.coursemall.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}
