package com.proyecto.tienda.domain.pojo.compraproducto;

import lombok.Getter;
import lombok.Setter;

/**
 * guardado de detalle de una compra de un producto
 */
@Getter@Setter
public class CompraProductoRequestPojo {
    /**
     * Id de la compra
     */
    private Long purchaseId;

    /**
     * id del producto
     */
    private Long productId;

    /**
     * cantidad de productos a comprar
     */
    private Integer quantity;

    /**
     * total a pagar
     */
    private Double total;

}
