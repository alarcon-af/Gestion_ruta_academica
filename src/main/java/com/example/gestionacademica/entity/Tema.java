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

    @Column(name = "titulo", length = 255)
    private String titulo;

    @Column(name = "material", length = 255)
    private String material;

    @JoinColumn(name = "requisito", referencedColumnName = "id_tema")
    private Integer requisito;

    @Column(name = "video", length = 255)
    private String video;
}
