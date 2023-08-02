package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private Double price;

    @Column(name = "tiposid")
    private Long typeId;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "tiposid", insertable = false, updatable = false)
    private TipoEntity tipo;

    @OneToMany(mappedBy = "productoEntity")
    private List<CompraProductoEntity> compraProductos;
}
