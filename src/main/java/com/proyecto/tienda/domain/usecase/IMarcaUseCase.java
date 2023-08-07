package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.pojo.marca.MarcaPojo;

import java.util.List;
import java.util.Optional;

public interface IMarcaUseCase {
    /**
     * @return retorna una lista con todas la Marcas de los productos
     */
    List<MarcaPojo> getAll();

    /**
     * Devuelve una marca de la tabla marcas
     * @param id identificador de la marca
     * @return Envuelve en un Optional la marca encontrada
     */
    Optional<MarcaPojo> getMarca(Long id);

    /**
     *Guarda una nueva marca de producto
     * @param newMarca marca a insertar en la base de datos
     * @return retorna la marca creada
     */
    MarcaPojo save(MarcaPojo newMarca);

    /**
     *actualiza una marca
     * @param marca marca a actualizar en la base de datos
     * @return retorna un optional que contendra la marca(si existe)
     */
    Optional<MarcaPojo> update(MarcaPojo marca);

    /**
     *Elimina una marca de base de datos
     * @param id de la marca a eliminar
     */
    boolean delete(Long id);
}
