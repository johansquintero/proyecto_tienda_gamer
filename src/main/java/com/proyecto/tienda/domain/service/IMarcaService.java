package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.MarcaPojo;

import java.util.List;
import java.util.Optional;

public interface IMarcaService {
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
     *Elimina una marca de base de datos
     * @param id de la marca a eliminar
     */
    boolean delete(Long id);
}
