package com.example.gestionacademica.controller;

import com.example.gestionacademica.entity.Syllabus;
import com.example.gestionacademica.service.SyllabusService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/syllabus")
public class SyllabusController {
    @Autowired
    private SyllabusService service;

    @GetMapping("/lista-syllabus")
    public ResponseEntity<List<Syllabus>> getAllRutas() {
        List<Syllabus> rutas =service.findAll();
        if(!rutas.isEmpty()){
            return new ResponseEntity<>(rutas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/syl/{mat}")
    public ResponseEntity<Syllabus> getByMateria(@PathVariable Integer mat){
        Optional<Syllabus> syl = service.findByMat(mat);
        return syl.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Syllabus> conseguirRuta(@PathVariable Integer id) {
        Optional<Syllabus> ruta = service.findById(id);
        return ruta.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Syllabus>> agregarRuta(@RequestBody Syllabus post){
        Optional<Syllabus> ruta = service.save(post);
        if(ruta.isPresent()){
            return new ResponseEntity<>(ruta, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarRuta(@PathVariable Integer id){
        Optional<Syllabus> ruta = service.findById(id);
        if(ruta.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Syllabus> actualizarRuta(@PathVariable Integer id, @RequestBody Syllabus rutaActualizado){
        Syllabus ruta = service.update(id, rutaActualizado);

        if(ruta != null){
            return new ResponseEntity<>(ruta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
