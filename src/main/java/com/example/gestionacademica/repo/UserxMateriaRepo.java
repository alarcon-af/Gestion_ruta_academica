package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.UserxMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserxMateriaRepo extends JpaRepository<UserxMateria, Integer>{

    @Query("SELECT c FROM UserxMateria c WHERE c.usuario = :usuario")
    List<UserxMateria> findByUsuario(String usuario);

    @Query("SELECT c FROM UserxMateria c WHERE c.usuario = :usuario AND c.materia = :materia")
    Optional<UserxMateria> findSpecificRelation(String usuario, Integer materia);
}
