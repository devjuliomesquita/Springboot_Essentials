package com.juliomesquita.essentials.services;

import com.juliomesquita.essentials.domain.Entities.StudentsEntity;
import com.juliomesquita.essentials.domain.dto.StudentsDTO;
import com.juliomesquita.essentials.domain.interfaces.StudentRepository;
import com.juliomesquita.essentials.domain.interfaces.StudentService;
import com.juliomesquita.essentials.mapper.StudentMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentsDTO create(String name) {
        StudentsEntity studentSaved = this.studentRepository.save(new StudentsEntity(name));
        return StudentMapper.toDto(studentSaved);
    }

    @Override
    public StudentsDTO update(Long id, String name) {
        StudentsEntity studentsEntity = this.studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id não existente."));
        studentsEntity.setName(name);
        StudentsEntity studentSaved = this.studentRepository.save(studentsEntity);
        return StudentMapper.toDto(studentSaved);
    }

    @Override
    public StudentsDTO delete(Long id) {
        StudentsEntity studentsEntity = this.studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id não existente."));
        this.studentRepository.deleteById(id);
        return StudentMapper.toDto(studentsEntity);
    }

    @Override
    public StudentsDTO findById(Long id) {
        Optional<StudentsEntity> studentsEntity = this.studentRepository.findById(id);
        return studentsEntity.map(StudentMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Id não existente."));
    }

    @Override
    public StudentsDTO findByName(String name) {
        Optional<StudentsEntity> studentsEntity = this.studentRepository.findByNameIgnoreCaseContaing(name);
        return studentsEntity.map(StudentMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Nome não existente."));
    }

    @Override
    public List<StudentsDTO> findAll() {
        List<StudentsEntity> entityList = this.studentRepository.findAll();
        return entityList.stream().map(StudentMapper::toDto).toList();
    }
}
