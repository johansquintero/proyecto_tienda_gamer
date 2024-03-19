package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.dto.marca.MarcaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMarcaUseCase {
    /**
     * @return retorna una lista con todas la Marcas de los productos
     */
    List<MarcaDto> getAll();

    /**
     *
     * @param pageable
     * @return devuelve el objeto paginator solicitado por el objeto pageable
     */
    Page<MarcaDto> getAllByPage(Pageable pageable);
    /**
     * Devuelve una marca de la tabla marcas
     * @param id identificador de la marca
     * @return Envuelve en un Optional la marca encontrada
     */
    Optional<MarcaDto> getMarca(Long id);

    /**
     *Guarda una nueva marca de producto
     * @param newMarca marca a insertar en la base de datos
     * @return retorna la marca creada
     */
    MarcaDto save(MarcaDto newMarca);

    /**
     *actualiza una marca
     * @param marca marca a actualizar en la base de datos
     * @return retorna un optional que contendra la marca(si existe)
     */
    Optional<MarcaDto> update(MarcaDto marca);

    /**
     *Elimina una marca de base de datos
     * @param id de la marca a eliminar
     */
    boolean delete(Long id);
}
