package com.example.gestionacademica.service;

import com.example.gestionacademica.repo.ContenidoRepo;
import com.example.gestionacademica.entity.Contenido;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepo matRepository;

    public List<Contenido> findAll() {
        return matRepository.findAll();
    }

    public List<Contenido> findSameSyllabus(Integer id_syl){
        return matRepository.findById_syl(id_syl);
    }


    public Optional<Contenido> findById(Integer id){
        Optional<Contenido> post = matRepository.findById(id);
        return post;
    }

    public Optional<Contenido> save(Contenido post){
        matRepository.save(post);
        Optional<Contenido> publicacion =matRepository.findById(post.getId_contenido());
        return publicacion;
    }

    public void delete(Integer id){
        matRepository.deleteById(id);
    }

    public Contenido update(Integer id, Contenido publicacion){
        Contenido post = matRepository.findById(id).orElse(null);

        if (post != null && publicacion != null){
            if(publicacion.getTitulo() != null){
                post.setTitulo(publicacion.getTitulo());
            }
            if(publicacion.getId_syl() != null){
                post.setId_syl(publicacion.getId_syl());
            }
            if(publicacion.getMaterial() != null){
                post.setMaterial(publicacion.getMaterial());
            }
            if(publicacion.getDescripcion() != null){
                post.setDescripcion(publicacion.getDescripcion());
            }
            if(publicacion.getVideo() != null){
                post.setVideo(publicacion.getVideo());
            }

            matRepository.save(post);
            return post;
        }else{
            return null;
        }
    }
}
