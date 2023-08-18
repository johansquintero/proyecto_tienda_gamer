package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class CompraEntity {
    /**
     * id de la compra
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * id del cliente que realiza la compra
     */
    @Column(name = "clientesid")
    private Long customerId;

    /**
     * fecha de la compra
     */
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    /**
     * total a pagar en la compra
     */
    @Column(name = "total")
    private Double total;

    /**
     * metodo de pago de la compra
     */
    @Column(name = "medio_pago")
    private String paymentMethod;

    /**
     * detalle de la compra que se obtiene al relacionar las compras con los productos
     */
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "compraEntity", cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    private Set<CompraProductoEntity> compraProductos;

    @ManyToOne
    @JoinColumn(name = "clientesid", insertable = false, updatable = false)
    private ClienteEntity clienteEntity;
}
