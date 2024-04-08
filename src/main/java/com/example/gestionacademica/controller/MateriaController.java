package com.example.gestionacademica.controller;

import com.example.gestionacademica.entity.Materia;
import com.example.gestionacademica.service.MateriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService service;

    @GetMapping("/lista-materias")
    public ResponseEntity<List<Materia>> getAllMaterias() {
        List<Materia> materias =service.findAll();
        if(!materias.isEmpty()){
            return new ResponseEntity<>(materias, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> conseguirMateria(@PathVariable Integer id) {
        Optional<Materia> materia = service.findById(id);
        return materia.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Materia>> agregarMateria(@RequestBody Materia post){
        Optional<Materia> materia = service.save(post);
        if(materia.isPresent()){
            return new ResponseEntity<>(materia, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarMateria(@PathVariable Integer id){
        Optional<Materia> materia = service.findById(id);
        if(materia.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Materia> actualizarMateria(@PathVariable Integer id, @RequestBody Materia materiaActualizado){
        Materia materia = service.update(id, materiaActualizado);

        if(materia != null){
            return new ResponseEntity<>(materia, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
