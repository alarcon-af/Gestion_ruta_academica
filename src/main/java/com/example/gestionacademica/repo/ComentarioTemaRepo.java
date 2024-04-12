package com.example.gestionacademica.repo;

import com.example.gestionacademica.entity.ComentarioTema;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComentarioTemaRepo extends JpaRepository<ComentarioTema, Integer> {
    @Query("SELECT c FROM ComentarioTema c WHERE c.id_tema = :id_tema")
    List<ComentarioTema> findById_post(Integer id_tema);

    @Modifying
    @Transactional
    @Query("DELETE FROM ComentarioTema c WHERE c.id_tema = :id_tema")
    void deleteById_post(@Param("id_tema") Integer id_tema);
}
