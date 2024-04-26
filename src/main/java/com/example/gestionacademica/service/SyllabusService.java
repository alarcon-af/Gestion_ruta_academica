package com.example.gestionacademica.service;

import com.example.gestionacademica.repo.SyllabusRepo;
import com.example.gestionacademica.entity.Syllabus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class SyllabusService {
    @Autowired
    private SyllabusRepo rutaRepository;

    public List<Syllabus> findAll() {
        return rutaRepository.findAll();
    }


    public Optional<Syllabus> findById(Integer id){
        Optional<Syllabus> post = rutaRepository.findById(id);
        return post;
    }

    public Optional<Syllabus> findByMat(Integer mat){
        Optional<Syllabus> syl = rutaRepository.findByMateria(mat);
        return syl;
    }

    public Optional<Syllabus> save(Syllabus post){
        rutaRepository.save(post);
        Optional<Syllabus> publicacion =rutaRepository.findById(post.getId_syllabus());
        return publicacion;
    }

    public void delete(Integer id){
        rutaRepository.deleteById(id);
    }

    public Syllabus update(Integer id, Syllabus publicacion){
        Syllabus post = rutaRepository.findById(id).orElse(null);

        if (post != null && publicacion != null){
            if(publicacion.getId_mat() != null){
                post.setId_mat(publicacion.getId_mat());
            }
            rutaRepository.save(post);
            return post;
        }else{
            return null;
        }
    }
}
