package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * Entidad de la tabla marca
 */
@Entity
@Table(name = "marcas")
@Getter
@Setter
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
    @Column(name = "nombre")
    private String name;

    @ManyToMany(mappedBy = "marcasEntities")
    private Set<TipoEntity> tiposEntities;

    @OneToMany(mappedBy = "marca")
    private Set<ProductoEntity> productos;
}
