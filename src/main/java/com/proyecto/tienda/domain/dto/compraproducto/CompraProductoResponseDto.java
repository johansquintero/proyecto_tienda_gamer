package com.proyecto.tienda.domain.dto.compraproducto;

import lombok.Getter;
import lombok.Setter;

/**
 * consulta de detalle de una compra
 */
@Getter
@Setter
public class CompraProductoResponseDto {
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
