package com.example.gestionacademica.controller;

import com.example.gestionacademica.service.ComentarioTemaService;
import com.example.gestionacademica.entity.ComentarioTema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/comentariotema")
public class ComentarioTemaController {

    @Autowired
    private ComentarioTemaService service;

    @GetMapping("/lista-comentarios")
    public ResponseEntity<List<ComentarioTema>> getAllComentarios() {
        List<ComentarioTema> comentarios =service.findAll();
        if(!comentarios.isEmpty()){
            return new ResponseEntity<>(comentarios, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lista-comentarios/{cat}")
    public ResponseEntity<List<ComentarioTema>> getPostsCat(@PathVariable Integer cat) {
        List<ComentarioTema> posts = service.findSamePost(cat);
        if(!posts.isEmpty()){
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioTema> conseguirComentario(@PathVariable Integer id) {
        Optional<ComentarioTema> com = service.findById(id);
        return com.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<ComentarioTema>> agregarComentario(@RequestBody ComentarioTema com){
        Optional<ComentarioTema> comentario = service.save(com);
        if(comentario.isPresent()){
            return new ResponseEntity<>(comentario, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarComentario(@PathVariable Integer id){
        Optional<ComentarioTema> com = service.findById(id);
        if(com.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar-por-post/{idPost}")
    public ResponseEntity<?> borrarComentariosPorPost(@PathVariable Integer idPost) {
        try {
            service.deleteByPostId(idPost);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al borrar comentarios por post");
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComentarioTema> actualizarComentario(@PathVariable Integer id, @RequestBody ComentarioTema comActualizado){
        ComentarioTema com = service.update(id, comActualizado);

        if(com != null){
            return new ResponseEntity<>(com, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
