package com.proyecto.tienda.domain.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto de consulta de una compra
 */
@Getter
@Setter
public class CompraResponsePojo {

    /**
     * id de la compra
     */
    private Long id;

    /**
     * id del cliente que realiza la compra
     */
    private Long customerId;

    /**
     * fecha de la compra
     */
    private LocalDateTime date;

    /**
     * total a pagar en la compra
     */
    private Double total;

    /**
     * metodo de pago de la compra
     */
    private String paymentMethod;

    /**
     * detalle de respuesta de la compra que se obtiene al relacionar las compras con los productos
     */
    private List<CompraProductoResponsePojo> compraProductos;
}
