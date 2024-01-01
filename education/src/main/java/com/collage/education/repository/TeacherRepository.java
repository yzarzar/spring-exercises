package com.collage.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collage.education.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
    
}
