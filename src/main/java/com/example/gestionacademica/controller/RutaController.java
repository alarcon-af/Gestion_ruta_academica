package com.example.gestionacademica.controller;


import com.example.gestionacademica.entity.Ruta;
import com.example.gestionacademica.service.RutaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    private RutaService service;

    @GetMapping("/lista-rutas")
    public ResponseEntity<List<Ruta>> getAllRutas() {
        List<Ruta> rutas =service.findAll();
        if(!rutas.isEmpty()){
            return new ResponseEntity<>(rutas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruta> conseguirRuta(@PathVariable Integer id) {
        Optional<Ruta> ruta = service.findById(id);
        return ruta.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Ruta>> agregarRuta(@RequestBody Ruta post){
        Optional<Ruta> ruta = service.save(post);
        if(ruta.isPresent()){
            return new ResponseEntity<>(ruta, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarRuta(@PathVariable Integer id){
        Optional<Ruta> ruta = service.findById(id);
        if(ruta.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ruta> actualizarRuta(@PathVariable Integer id, @RequestBody Ruta rutaActualizado){
        Ruta ruta = service.update(id, rutaActualizado);

        if(ruta != null){
            return new ResponseEntity<>(ruta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
