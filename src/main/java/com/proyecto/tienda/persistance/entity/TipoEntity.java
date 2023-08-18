package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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
    private String name;

    @OneToMany(mappedBy = "tipo")
    private List<ProductoEntity> productos;

    @ManyToMany
    @JoinTable(name = "tipos_marcas",
            joinColumns = @JoinColumn(name = "tiposid"),
            inverseJoinColumns = @JoinColumn(name = "marcasid"))
    private Set<MarcaEntity> marcasEntities;
}
