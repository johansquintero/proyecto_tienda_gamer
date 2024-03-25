package com.proyecto.tienda.domain.dto.compraproducto;

import lombok.Getter;
import lombok.Setter;

/**
 * guardado de detalle de una compra de un producto
 */
@Getter@Setter
public class CompraProductoRequestDto {
    /**
     * Id de la compra
     */
    private Long purchaseId;

    /**
     * id del producto
     */
    private Long productId;

    /**
     * cantidad del producto a comprar
     */
    private Integer quantity;

    /**
     * total a pagar
     */
    private Double total;

}
