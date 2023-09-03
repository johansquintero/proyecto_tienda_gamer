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

    @Column(name = "tiposid")
    private long tipoId;

    @Column(name = "marcasid")
    private long marcaId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private Double price;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "tiposid", insertable = false, updatable = false)
    private TipoEntity tipo;

    @ManyToOne
    @JoinColumn(name = "marcasid", insertable = false,  updatable = false)
    private MarcaEntity marca;

    @OneToMany(mappedBy = "productoEntity")
    private List<CompraProductoEntity> compraProductos;
}
