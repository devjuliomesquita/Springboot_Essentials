package com.juliomesquita.essentials.domain.interfaces;

import com.juliomesquita.essentials.domain.dto.StudentDTOWithoutId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentsController {
    @GetMapping(path = "/{id}")
    ResponseEntity<?> getStudentById(@PathVariable(name = "id") Long id);

    @GetMapping(path = "/{name}/name")
    ResponseEntity<?> getStudentByName(@PathVariable(name = "name") String name);

    @GetMapping()
    ResponseEntity<List<?>> getListStudent();

    @PostMapping()
    ResponseEntity<?> createStudent(@RequestBody StudentDTOWithoutId studentDTOWithoutId);

    @PutMapping(path = "/{id}")
    ResponseEntity<?> updateStudent(@PathVariable(name = "id") Long id, @RequestBody StudentDTOWithoutId studentDTOWithoutId);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id);
}
