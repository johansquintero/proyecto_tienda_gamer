package com.proyecto.tienda.domain.pojo.compraproducto;

import lombok.Getter;
import lombok.Setter;

/**
 * consulta de detalle de una compra
 */
@Getter
@Setter
public class CompraProductoResponsePojo {
    /**
     *Nombre del producto a referenciar
     */
    private String productName;

    /**
     * cantidad de productos a comprar
     */
    private Integer quantity;

    /**
     * total a pagar
     */
    private Double total;
}
