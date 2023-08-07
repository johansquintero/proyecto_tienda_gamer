package com.proyecto.tienda.domain.pojo.tipo;

import com.proyecto.tienda.domain.pojo.marca.MarcaIdPojo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Dto de request para el guardado de los tipos
 */
@Getter@Setter
public class TipoSavePojo {
    /**
     * identificador del tipo
     */
    private Long id;
    /**
     * nombre del tipo
     */
    private String name;

    /**
     * Marcas que mapean la relacion entre un tipo y una marca por el id
     */
    private List<MarcaIdPojo> marcaIdPojoList;
}
