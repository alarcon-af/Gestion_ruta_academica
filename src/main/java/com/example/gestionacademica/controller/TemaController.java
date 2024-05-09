package com.example.gestionacademica.controller;

import com.example.gestionacademica.entity.Tema;
import com.example.gestionacademica.service.TemaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaService service;

    @GetMapping("/lista-temas")
    public ResponseEntity<List<Tema>> getAllTemas() {
        List<Tema> temas =service.findAll();
        if(!temas.isEmpty()){
            return new ResponseEntity<>(temas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> conseguirTema(@PathVariable Integer id) {
        Optional<Tema> tema = service.findById(id);
        return tema.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/lista-temas/{id}")
    public ResponseEntity<List<Tema>> getTemasByRuta(@PathVariable Integer id){
        List<Tema> temas = service.findByRuta(id);
        if(!temas.isEmpty()){
            return new ResponseEntity<>(temas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Tema>> agregarTema(@RequestBody Tema post){
        Optional<Tema> tema = service.save(post);
        if(tema.isPresent()){
            return new ResponseEntity<>(tema, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarTema(@PathVariable Integer id){
        Optional<Tema> tema = service.findById(id);
        if(tema.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Tema> actualizarTema(@PathVariable Integer id, @RequestBody Tema postActualizado){
        Tema post = service.update(id, postActualizado);

        if(post != null){
            return new ResponseEntity<>(post, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
