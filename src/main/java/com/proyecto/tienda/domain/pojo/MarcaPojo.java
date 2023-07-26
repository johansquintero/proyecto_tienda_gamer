package com.proyecto.tienda.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 *Pojo de marca de producto
 */

@Getter@Setter
public class MarcaPojo {
    /**
     * id de la marca
     */
    private Long id;

    /**
     * descripcion de la marca
     */
    private String description;
}
