package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de la tabla marca
 */
@Entity
@Table(name="marcas")
@Getter@Setter
public class MarcaEntity {
    /**
     * Columna id de la tabla marca
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Columna descripcion de la tabla marca
     */
    @Column(name="descripcion")
    @NotNull
    private String description;



}
