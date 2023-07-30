package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipos")
public class TipoEntity {
    /**
     * identificador del tipo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * nombre del tipo
     */
    @Column(name = "nombre")
    private String nombre;

}
