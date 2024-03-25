package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carrito")

public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * id del cliente que realiza la compra
     */
    @Column(name = "clienteid")
    private Long customerId;

    @ManyToMany
    @JoinTable(
            name = "carrito_productos",
            joinColumns = @JoinColumn(name = "carritoid"),
            inverseJoinColumns = @JoinColumn(name = "productosid")
    )
    private List<ProductoEntity> productos;

    // Getters y Setters
    @OneToOne
    @JoinColumn(name = "clienteid", insertable = false, updatable = false)
    private ClienteEntity cliente;

}
