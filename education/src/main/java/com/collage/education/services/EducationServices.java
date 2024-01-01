package com.collage.education.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.collage.education.entity.Student;
import com.collage.education.entity.Subject;
import com.collage.education.entity.Teacher;
import com.collage.education.repository.StudentRepository;
import com.collage.education.repository.SubjectRepository;
import com.collage.education.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationServices {
    
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    public List<Subject> findSubject() {
        return subjectRepository.findAll();
    }
    public List<Student> findStudent() {
        return studentRepository.findAll();
    }
    public List<Teacher> findTeacher() {
        return teacherRepository.findAll();
    }

    public Subject enrollStudentToSubject(
        @PathVariable Integer subjectId,
        @PathVariable Integer studentId
        ) {
        Subject subject = subjectRepository.findById(studentId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }
}
 