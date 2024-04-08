package com.example.gestionacademica.controller;

import com.example.gestionacademica.entity.Contenido;
import com.example.gestionacademica.service.ContenidoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Base64;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {
    @Autowired
    private ContenidoService service;

    @GetMapping("/lista-contenidos")
    public ResponseEntity<List<Contenido>> getAllTemas() {
        List<Contenido> temas =service.findAll();
        if(!temas.isEmpty()){
            return new ResponseEntity<>(temas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lista-contenidos/{syl}")
    public ResponseEntity<List<Contenido>> getPostsCat(@PathVariable Integer syl) {
        List<Contenido> posts = service.findSameSyllabus(syl);
        if(!posts.isEmpty()){
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> conseguirTema(@PathVariable Integer id) {
        Optional<Contenido> tema = service.findById(id);
        return tema.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Contenido>> agregarTema(@RequestBody Contenido post){
        Optional<Contenido> tema = service.save(post);
        if(tema.isPresent()){
            return new ResponseEntity<>(tema, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarTema(@PathVariable Integer id){
        Optional<Contenido> tema = service.findById(id);
        if(tema.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Contenido> actualizarTema(@PathVariable Integer id, @RequestBody Contenido postActualizado){
        Contenido post = service.update(id, postActualizado);

        if(post != null){
            return new ResponseEntity<>(post, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
