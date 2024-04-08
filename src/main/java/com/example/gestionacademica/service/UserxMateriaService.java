package com.example.gestionacademica.service;

import com.example.gestionacademica.entity.Materia;
import com.example.gestionacademica.repo.MateriaRepo;
import com.example.gestionacademica.repo.UserxMateriaRepo;
import com.example.gestionacademica.entity.UserxMateria;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class UserxMateriaService {

    @Autowired
    private UserxMateriaRepo userRepository;

    public List<UserxMateria> findAll() {
        return userRepository.findAll();
    }


    public Optional<UserxMateria> findById(Integer id){
        Optional<UserxMateria> post = userRepository.findById(id);
        return post;
    }

    public Optional<UserxMateria> save(UserxMateria post){
        userRepository.save(post);
        Optional<UserxMateria> publicacion =userRepository.findById(post.getId_materia());
        return publicacion;
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public UserxMateria update(Integer id, UserxMateria publicacion){
        UserxMateria post = userRepository.findById(id).orElse(null);

        if (post != null && publicacion != null){
            if(publicacion.getId_materia() != null){
                post.setId_materia(publicacion.getId_materia());
            }
            if(publicacion.getId_usuario() != null){
                post.setId_usuario(publicacion.getId_usuario());
            }

            userRepository.save(post);
            return post;
        }else{
            return null;
        }
    }
}
