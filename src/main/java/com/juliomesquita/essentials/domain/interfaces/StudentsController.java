package com.juliomesquita.essentials.domain.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentsController {
    @GetMapping(path = "/{id}")
    ResponseEntity<?> getStudentById(@PathVariable(name = "id") Long id);

    @GetMapping(path = "/{name}")
    ResponseEntity<?> getStudentByName(@PathVariable(name = "name") String name);

    @GetMapping()
    ResponseEntity<List<?>> getListStudent();

    @PostMapping()
    ResponseEntity<?> createStudent(String name);

    @PutMapping(path = "/{id}")
    ResponseEntity<?> updateStudent(@PathVariable(name = "id") Long id, String name);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id);
}
