package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContenidoRepo extends JpaRepository<Contenido, Integer>{
    @Query("SELECT c FROM Contenido c WHERE c.id_syl = :id_syl")
    List<Contenido> findById_syl(Integer id_syl);
}
