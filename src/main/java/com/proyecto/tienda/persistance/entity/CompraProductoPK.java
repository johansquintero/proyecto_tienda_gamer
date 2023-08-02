package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CompraProductoPK implements Serializable {

    @Serial
    private static final long serialVersionUID = -2145479604343286721L;

    /**
     * Id de la compra
     */
    @Column(name="comprasid")
    private Long purchaseId;

    /**
     * id del producto
     */
    @Column(name="productosid")
    private Long productId;
}
