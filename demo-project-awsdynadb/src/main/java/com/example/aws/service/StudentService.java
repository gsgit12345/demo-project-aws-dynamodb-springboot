package com.example.aws.service;

import com.example.aws.entity.Student;
import com.example.aws.exception.EntityNotFoundException;
import com.example.aws.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public Iterable<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudent(String id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            return student;
        }
        else
            throw new EntityNotFoundException("Student not found with the given ID");
    }

    public Student updateStudent(Student student, String id) {
        boolean exists = studentRepo.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("Student(id- " + id + ") Not Found !!");
        }
        else
            student.setId(id);
        return studentRepo.save(student);
    }

    public void deleteStudent(String id) {
        boolean exists = studentRepo.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("Student(id- " + id + ") Not Found !!");
        }
        else
            studentRepo.deleteById(id);
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

}
