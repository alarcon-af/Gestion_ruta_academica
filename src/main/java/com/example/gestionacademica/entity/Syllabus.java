package com.example.gestionacademica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="SYLLABUS")
@Entity
public class Syllabus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_syllabus", length = 255)
    private Integer id_syllabus;

    @JoinColumn(name = "id_mat", referencedColumnName = "id_materia")
    private Integer id_mat;
}
