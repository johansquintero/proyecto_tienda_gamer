package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class CompraProductoEntity {
    /**
     *id embeido de las llaves compuestas
     */
    @EmbeddedId
    private CompraProductoPK id;

    /**
     * cantidad de productos a comprar
     */
    @Column(name="cantidad")
    private Integer quantity;

    /**
     * total a pagar
     */
    @Column(name = "total")
    private Double total;

    /**
     * entidad de la compra a relacionar con el detalle
     * El id de compraEntity se apunta con mapsId a purchaseId para que se pueda guardar en la tabla intermedia
     * esto se debe a que desde el fronted se envia solamente el id del producto, pero no la compra, ya que esta se crea es en el servicio
     */
    @ManyToOne
    @MapsId(value = "purchaseId")
    @JoinColumn(name = "comprasid", insertable = false,updatable = false)
    private CompraEntity compraEntity;

    @ManyToOne
    @JoinColumn(name = "productosid",insertable = false,updatable = false)
    private ProductoEntity productoEntity;
}
