package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepo extends JpaRepository<Materia, Integer>{
}
