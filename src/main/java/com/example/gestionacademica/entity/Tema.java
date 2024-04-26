package com.example.gestionacademica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="TEMA")
@Entity
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tema", length = 255)
    private Integer id_tema;

    @JoinColumn(name = "ruta", referencedColumnName = "id_ruta")
    private Integer ruta;

    @JoinColumn(name = "contenido", referencedColumnName = "id_contenido")
    private Integer contenido;

    @Column(name = "titulo", length = 255)
    private String titulo;

    @Column(name = "foto", length = 255)
    private String foto;

    @Column(name = "estado", length = 255)
    private String estado;
}
