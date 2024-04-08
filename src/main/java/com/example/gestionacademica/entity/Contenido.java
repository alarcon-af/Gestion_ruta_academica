package com.example.gestionacademica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="CONTENIDO")
@Entity
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenido", length = 255)
    private Integer id_contenido;

    @Column(name = "titulo", length = 255)
    private String titulo;

    @JoinColumn(name = "id_syl", referencedColumnName = "id_syllabus")
    private Integer id_syl;

    @Column(name = "material", length = 255)
    private String material;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "video", length = 255)
    private String video;
}
