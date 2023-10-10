package com.empowher.coursemall.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "course")
@EqualsAndHashCode(of = {"id"})
public class Course {
	@Id
	private String id;
	private String name;
	private String category;
	private String link;
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private Author author;
	
	@PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
 
    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
	
}