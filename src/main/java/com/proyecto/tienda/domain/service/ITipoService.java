package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.TipoPojo;

import java.util.List;
import java.util.Optional;

public interface ITipoService {
    /**
     * @return retorna una lista con todas las tipos de producto
     */
    List<TipoPojo> getAll();

    /**
     * Devuelve un tipo dado su ID
     * @param id identificador del tipo
     * @return devuelve un Optional del tipo
     */
    Optional<TipoPojo> getTipo(Long id);

    /**
     *Guarda un nuevo tipo de producto
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    TipoPojo save(TipoPojo newTipo);

    /**
     *actualiza un nuevo tipo de producto
     * @param tipo tipo a actualizar en la base de datos
     * @return retorna el tipo creado
     */
    Optional<TipoPojo> update(TipoPojo tipo);


    /**
     *Elimina un tipo de base de datos
     * @param id identifiacor del tipo a eliminar
     */
    boolean delete(Long id);
}
