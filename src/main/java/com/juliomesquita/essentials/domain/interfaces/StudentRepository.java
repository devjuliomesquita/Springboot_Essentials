package com.juliomesquita.essentials.domain.interfaces;

import com.juliomesquita.essentials.domain.Entities.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentsEntity, Long> {

    Optional<StudentsEntity> findByNameIgnoreCaseContaining(String name);

}
