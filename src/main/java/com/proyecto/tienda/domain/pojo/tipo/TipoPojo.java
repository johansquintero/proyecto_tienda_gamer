package com.proyecto.tienda.domain.pojo.tipo;

import com.proyecto.tienda.domain.pojo.marca.MarcaPojo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Objeto plano de java referente a los tipos de productos
 */
@Getter
@Setter
public class TipoPojo {
    /**
     * identificador del tipo
     */
    private Long id;
    /**
     * nombre del tipo
     */
    private String name;

    /**
     * Marcas que mapean la relacion entre un tipo y una marca con sus atributos
     */
    private List<MarcaPojo> marcas;
}
