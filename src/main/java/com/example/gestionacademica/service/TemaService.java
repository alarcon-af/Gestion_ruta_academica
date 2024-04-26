package com.example.gestionacademica.service;

import com.example.gestionacademica.repo.TemaRepo;
import com.example.gestionacademica.entity.Tema;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class TemaService {

    @Autowired
    private TemaRepo matRepository;

    public List<Tema> findAll() {
        return matRepository.findAll();
    }


    public Optional<Tema> findById(Integer id){
        Optional<Tema> post = matRepository.findById(id);
        return post;
    }

    public List<Tema> findByRuta(Integer id){
        return matRepository.findByRuta(id);
    }

    public Optional<Tema> save(Tema post){
        matRepository.save(post);
        Optional<Tema> publicacion =matRepository.findById(post.getId_tema());
        return publicacion;
    }

    public void delete(Integer id){
        matRepository.deleteById(id);
    }

    public Tema update(Integer id, Tema publicacion){
        Tema post = matRepository.findById(id).orElse(null);

        if (post != null && publicacion != null){
            if(publicacion.getRuta()!= null){
                post.setRuta(publicacion.getRuta());
            }
            if(publicacion.getContenido() != null){
                post.setContenido(publicacion.getContenido());
            }
            if(publicacion.getTitulo() != null){
                post.setTitulo(publicacion.getTitulo());
            }
            if(publicacion.getFoto() != null){
                post.setFoto(publicacion.getFoto());
            }
            if(publicacion.getEstado() != null){
                post.setEstado(publicacion.getEstado());
            }
            matRepository.save(post);
            return post;
        }else{
            return null;
        }
    }
}
