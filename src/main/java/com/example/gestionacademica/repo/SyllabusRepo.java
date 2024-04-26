package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SyllabusRepo extends JpaRepository<Syllabus, Integer>{

    @Query("SELECT c FROM Syllabus c WHERE c.id_mat = :mat")
    Optional<Syllabus> findByMateria(Integer mat);
}
