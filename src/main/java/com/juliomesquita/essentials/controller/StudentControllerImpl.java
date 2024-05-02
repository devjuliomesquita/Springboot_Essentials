package com.juliomesquita.essentials.controller;

import com.juliomesquita.essentials.domain.interfaces.StudentService;
import com.juliomesquita.essentials.domain.interfaces.StudentsController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentControllerImpl implements StudentsController {
    private final StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public ResponseEntity<?> getStudentById(Long id) {
        return new ResponseEntity<>(this.studentService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getStudentByName(String name) {
        return new ResponseEntity<>(this.studentService.findByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<?>> getListStudent() {
        return new ResponseEntity<>(this.studentService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createStudent(String name) {
        return new ResponseEntity<>(this.studentService.create(name), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateStudent(Long id, String name) {
        return new ResponseEntity<>(this.studentService.update(id, name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteStudent(Long id) {
        return new ResponseEntity<>(this.studentService.delete(id), HttpStatus.NO_CONTENT);
    }
}
