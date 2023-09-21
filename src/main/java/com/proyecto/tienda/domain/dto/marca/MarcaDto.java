package com.proyecto.tienda.domain.dto.marca;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca de producto
 */

@Getter@Setter
public class MarcaDto {
    /**
     * id de la marca
     */
    private Long id;

    /**
     * descripcion de la marca
     */
    private String name;
}
