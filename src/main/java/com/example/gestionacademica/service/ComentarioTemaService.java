package com.example.gestionacademica.service;

import com.example.gestionacademica.entity.ComentarioTema;
import com.example.gestionacademica.repo.ComentarioTemaRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class ComentarioTemaService {

    @Autowired
    private ComentarioTemaRepo comRepository;

    public List<ComentarioTema> findAll() {
        return comRepository.findAll();
    }

    public List<ComentarioTema> findSamePost(Integer id_post){
        return comRepository.findById_post(id_post);
    }

    public Optional<ComentarioTema> findById(Integer id){
        Optional<ComentarioTema> com = comRepository.findById(id);
        return com;
    }

    public Optional<ComentarioTema> save(ComentarioTema com){
        comRepository.save(com);
        Optional<ComentarioTema> comentario =comRepository.findById(com.getId_com());
        return comentario;
    }

    public void delete(Integer id){
        comRepository.deleteById(id);
    }

    public void deleteByPostId(Integer idPost) {
        comRepository.deleteById_post(idPost);
    }

    public ComentarioTema update(Integer id, ComentarioTema comentario){
        ComentarioTema com = comRepository.findById(id).orElse(null);

        if (com != null && comentario != null){
            if(comentario.getNombre() != null){
                com.setNombre(comentario.getNombre());
            }
            if(comentario.getMensaje() != null){
                com.setMensaje(comentario.getMensaje());
            }
            if(comentario.getValoracion() != null){
                com.setValoracion(comentario.getValoracion());
            }
            comRepository.save(com);
            return com;
        }else{
            return null;
        }
    }
}
