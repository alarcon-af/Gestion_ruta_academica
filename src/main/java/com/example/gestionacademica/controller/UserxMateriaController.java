package com.example.gestionacademica.controller;

import com.example.gestionacademica.entity.Materia;
import com.example.gestionacademica.entity.UserxMateria;
import com.example.gestionacademica.service.MateriaService;
import com.example.gestionacademica.service.UserxMateriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/userxmateria")
public class UserxMateriaController {

    @Autowired
    private UserxMateriaService service;

    @GetMapping("/lista-relaciones")
    public ResponseEntity<List<UserxMateria>> getAllRelaciones() {
        List<UserxMateria> relaciones =service.findAll();
        if(!relaciones.isEmpty()){
            return new ResponseEntity<>(relaciones, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lista-relaciones/{id}")
    public ResponseEntity<List<UserxMateria>> getRelacionesByUser(String usuario){
        List<UserxMateria> relaciones = service.findById_usuario(usuario);
        if(!relaciones.isEmpty()){
            return new ResponseEntity<>(relaciones, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserxMateria> conseguirRelacion(@PathVariable Integer id) {
        Optional<UserxMateria> relacion = service.findById(id);
        return relacion.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<UserxMateria>> agregarRelacion(@RequestBody UserxMateria post){
        Optional<UserxMateria> relacion = service.save(post);
        if(relacion.isPresent()){
            return new ResponseEntity<>(relacion, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarRelacion(@PathVariable Integer id){
        Optional<UserxMateria> relacion = service.findById(id);
        if(relacion.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UserxMateria> actualizarRelacion(@PathVariable Integer id, @RequestBody UserxMateria relacionActualizado){
        UserxMateria relacion = service.update(id, relacionActualizado);

        if(relacion != null){
            return new ResponseEntity<>(relacion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
