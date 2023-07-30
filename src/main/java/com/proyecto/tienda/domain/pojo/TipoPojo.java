package com.proyecto.tienda.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto plano de java referente a los tipos de productos
 */
@Getter@Setter
public class TipoPojo {
    /**
     * identificador del tipo
     */
    private Long id;
    /**
     * nombre del tipo
     */
    private String name;
}
