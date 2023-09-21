package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.dto.tipo.TipoDto;

import java.util.List;
import java.util.Optional;

public interface ITipoUseCase {
    /**
     * @return retorna una lista con todas las tipos de producto
     */
    List<TipoDto> getAll();

    /**
     * Devuelve un tipo dado su ID
     * @param id identificador del tipo
     * @return devuelve un Optional del tipo
     */
    Optional<TipoDto> getTipo(Long id);

    /**
     *Guarda un nuevo tipo de producto
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    TipoDto save(TipoDto newTipo);

    /**
     *actualiza un nuevo tipo de producto
     * @param tipo tipo a actualizar en la base de datos
     * @return retorna el tipo creado
     */
    Optional<TipoDto> update(TipoDto tipo);


    /**
     *Elimina un tipo de base de datos
     * @param id identifiacor del tipo a eliminar
     */
    boolean delete(Long id);
}
