package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RutaRepo extends JpaRepository<Ruta, Integer>{

    @Query("SELECT c FROM Ruta c WHERE c.id_user_mat = :id")
    public Optional<Ruta> findByUsermat(Integer id);
}
