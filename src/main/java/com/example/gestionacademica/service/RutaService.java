package com.example.gestionacademica.service;

import com.example.gestionacademica.repo.RutaRepo;
import com.example.gestionacademica.entity.Ruta;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class RutaService {

    @Autowired
    private RutaRepo rutaRepository;

    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }


    public Optional<Ruta> findById(Integer id){
        Optional<Ruta> post = rutaRepository.findById(id);
        return post;
    }

    public Optional<Ruta> save(Ruta post){
        rutaRepository.save(post);
        Optional<Ruta> publicacion =rutaRepository.findById(post.getId_ruta());
        return publicacion;
    }

    public void delete(Integer id){
        rutaRepository.deleteById(id);
    }

    public Ruta update(Integer id, Ruta publicacion){
        Ruta post = rutaRepository.findById(id).orElse(null);

        if (post != null && publicacion != null){
            if(publicacion.getId_user_mat() != null){
                post.setId_user_mat(publicacion.getId_user_mat());
            }
            rutaRepository.save(post);
            return post;
        }else{
            return null;
        }
    }
}
