package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String title;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private Double price;

    @Column(name = "tiposid")
    private Long typeId;

    @Column(name = "cantidad")
    private Integer amount;

    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "tiposid", insertable = false, updatable = false)
    private TipoEntity tipo;

}
