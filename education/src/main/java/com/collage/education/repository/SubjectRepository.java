package com.collage.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collage.education.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
    
}
