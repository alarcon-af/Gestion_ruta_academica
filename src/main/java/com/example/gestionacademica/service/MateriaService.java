package com.example.gestionacademica.service;

import com.example.gestionacademica.repo.MateriaRepo;
import com.example.gestionacademica.entity.Materia;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepo matRepository;

    public List<Materia> findAll() {
        return matRepository.findAll();
    }


    public Optional<Materia> findById(Integer id){
        Optional<Materia> post = matRepository.findById(id);
        return post;
    }

    public Optional<Materia> save(Materia post){
        matRepository.save(post);
        Optional<Materia> publicacion =matRepository.findById(post.getId_materia());
        return publicacion;
    }

    public void delete(Integer id){
        matRepository.deleteById(id);
    }

    public Materia update(Integer id, Materia publicacion){
        Materia post = matRepository.findById(id).orElse(null);

        if (post != null && publicacion != null){
            if(publicacion.getNombre() != null){
                post.setNombre(publicacion.getNombre());
            }

            matRepository.save(post);
            return post;
        }else{
            return null;
        }
    }
}
