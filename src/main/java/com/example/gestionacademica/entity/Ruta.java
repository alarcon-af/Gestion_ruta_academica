package com.example.gestionacademica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="RUTA")
@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta", length = 255)
    private Integer id_ruta;

    @JoinColumn(name = "id_user_mat", referencedColumnName = "id_user_mat")
    private Integer id_user_mat;
}
