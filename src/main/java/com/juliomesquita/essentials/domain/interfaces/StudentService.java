package com.juliomesquita.essentials.domain.interfaces;

import com.juliomesquita.essentials.domain.dto.StudentsDTO;

import java.util.List;

public interface StudentService {
    StudentsDTO create(String name);
    StudentsDTO update(Long id, String name);
    StudentsDTO delete(Long id);
    StudentsDTO findById(Long id);
    StudentsDTO findByName(String name);
    List<StudentsDTO> findAll();
}
