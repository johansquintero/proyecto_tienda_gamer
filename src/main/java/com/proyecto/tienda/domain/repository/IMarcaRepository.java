package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.pojo.MarcaPojo;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del repositorio de la marca
 */
public interface IMarcaRepository {
    /**
     * @return retorna una lista con todas la Marcas de los productos
     */
    List<MarcaPojo> getAll();

    /**
     * Devuelve una marca dado su ID
     * @param id identificador de la marca
     * @return devuelve un Optional de la marca
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
     * @param id identifiacor de la marca a eliminar
     */
    void delete(Long id);
}
