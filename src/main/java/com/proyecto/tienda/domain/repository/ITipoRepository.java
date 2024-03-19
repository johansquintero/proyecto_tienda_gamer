package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.dto.tipo.TipoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del repositorio del tipo
 */
public interface ITipoRepository {
    /**
     * @return retorna una lista con todas las tipos de producto
     */
    List<TipoDto> getAll();

    /**
     *
     * @return Objeto pagina de tipoDto solicitada por el bojeto pageable
     */
    Page<TipoDto> getAllByPage(Pageable pageable);

    /**
     * Devuelve un tipo dado su ID
     * @param id identificador del tipo
     * @return devuelve un Optional del tipo
     */
    Optional<TipoDto> getTipo(Long id);


    /**
     * Devuelve un tipo a partir de su nombre
     * @param name
     * @return Optional del tipo encontrado
     */

    Optional<TipoDto> getByName(String name);

    /**
     *Guarda un nuevo tipo de producto
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    TipoDto save(TipoDto newTipo);

    /**
     * Elimina un tipo de base de datos
     *
     * @param id identifiacor del tipo a eliminar
     * @return
     */
    boolean delete(Long id);
}
