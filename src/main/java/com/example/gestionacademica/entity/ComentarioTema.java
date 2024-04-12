package com.example.gestionacademica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="COMENTARIOTEMA")
@Entity
public class ComentarioTema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_com", length = 255)
    private Integer id_com;

    @Column(name = "id_comentador", length = 255)
    private Integer id_comentador;

    @JoinColumn(name = "id_tema", referencedColumnName = "id_contenido")
    private Integer id_tema;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @Column(name = "mensaje", length = 255)
    private String mensaje;

    @Column(name = "valoracion", length = 255)
    private Integer valoracion;

    @Column(name = "fecha", length = 255)
    private Date fecha;
}
