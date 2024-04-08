package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface SyllabusRepo extends JpaRepository<Syllabus, Integer>{
}
