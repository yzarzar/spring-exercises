package com.collage.education.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collage.education.entity.Student;
import com.collage.education.entity.Subject;
import com.collage.education.entity.Teacher;
import com.collage.education.services.EducationServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

;



@RestController
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationController {
    
    private final EducationServices educationServices;

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody Subject subject) {
        return educationServices.createSubject(subject);
    }

    @PostMapping("/student")
    public Student createSubject(@RequestBody Student student) {
        return educationServices.createStudent(student);
    }

    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return educationServices.createTeacher(teacher);
    }

    @GetMapping("/subject")
    public List<Subject> getSubject() {
        return educationServices.findSubject();
    }
    
    @GetMapping("/student")
    public List<Student> getStudent() {
        return educationServices.findStudent();
    }

    @GetMapping("/teacher")
    public List<Teacher> getTeacher() {
        return educationServices.findTeacher();
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public Subject enrollStudentToSubject(
        @PathVariable Integer subjectId,
        @PathVariable Integer studentId
        ) {
        return educationServices.enrollStudentToSubject(subjectId, studentId);
    }

    @PutMapping("/{subjectId}/teachers/{teacherId}")
    public Subject assignTeacherToSubject(
        @PathVariable Integer subjectId,
        @PathVariable Integer teacherId
        ) {
        return educationServices.assignSubject(subjectId, teacherId);
    }
}
