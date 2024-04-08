package com.example.gestionacademica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="USERXMATERIA")
@Entity

public class UserxMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_mat", length = 255)
    private Integer id_user_mat;

    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    private Integer id_materia;

    @Column(name = "id_usuario", length = 255)
    private Integer id_usuario;
}
