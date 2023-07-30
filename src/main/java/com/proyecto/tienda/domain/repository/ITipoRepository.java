package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.pojo.ClientePojo;
import com.proyecto.tienda.domain.pojo.TipoPojo;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del repositorio del tipo
 */
public interface ITipoRepository {
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
     * Devuelve un tipo a partir de su nombre
     * @param nombre
     * @return Optional del tipo encontrado
     */

    Optional<TipoPojo> getByNombre(String nombre);

    /**
     *Guarda un nuevo tipo de producto
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    TipoPojo save(TipoPojo newTipo);

    /**
     *Elimina un tipo de base de datos
     * @param id identifiacor del tipo a eliminar
     */
    void delete(Long id);
}
