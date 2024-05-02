package com.juliomesquita.essentials.mapper;

import com.juliomesquita.essentials.domain.Entities.StudentsEntity;
import com.juliomesquita.essentials.domain.dto.StudentsDTO;

public class StudentMapper {
    private StudentMapper() {}
    public static StudentsDTO toDto(StudentsEntity entity){
        return new StudentsDTO(entity.getId(), entity.getName());
    }
}
