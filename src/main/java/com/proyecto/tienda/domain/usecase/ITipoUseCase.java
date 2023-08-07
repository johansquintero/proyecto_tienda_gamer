package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.pojo.tipo.TipoPojo;
import com.proyecto.tienda.domain.pojo.tipo.TipoSavePojo;

import java.util.List;
import java.util.Optional;

public interface ITipoUseCase {
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
    TipoSavePojo save(TipoSavePojo newTipo);

    /**
     *actualiza un nuevo tipo de producto
     * @param tipo tipo a actualizar en la base de datos
     * @return retorna el tipo creado
     */
    Optional<TipoSavePojo> update(TipoSavePojo tipo);


    /**
     *Elimina un tipo de base de datos
     * @param id identifiacor del tipo a eliminar
     */
    boolean delete(Long id);
}
