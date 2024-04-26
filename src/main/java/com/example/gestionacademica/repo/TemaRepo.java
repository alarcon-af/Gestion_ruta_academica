package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemaRepo extends JpaRepository<Tema, Integer>{

    public List<Tema> findByRuta(Integer ruta);
}
