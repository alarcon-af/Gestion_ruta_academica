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

    public List<UserxMateria> findById_usuario(String usuario){ return userRepository.findByUsuario(usuario); }

    public Optional<UserxMateria> findById(Integer id){
        Optional<UserxMateria> post = userRepository.findById(id);
        return post;
    }

    public Optional<UserxMateria> save(UserxMateria post){
        userRepository.save(post);
        Optional<UserxMateria> publicacion =userRepository.findById(post.getId_user_mat());
        return publicacion;
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public UserxMateria update(Integer id, UserxMateria publicacion){
        UserxMateria post = userRepository.findById(id).orElse(null);

        if (post != null && publicacion != null){
            if(publicacion.getMateria() != null){
                post.setMateria(publicacion.getMateria());
            }
            if(publicacion.getUsuario() != null){
                post.setUsuario(publicacion.getUsuario());
            }
            userRepository.save(post);
            return post;
        }else{
            return null;
        }
    }
}
