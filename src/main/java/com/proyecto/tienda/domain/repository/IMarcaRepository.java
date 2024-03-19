package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.dto.marca.MarcaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del repositorio de la marca
 */
public interface IMarcaRepository {
    /**
     * @return retorna una lista con todas la Marcas de los productos
     */
    List<MarcaDto> getAll();

    public Page<MarcaDto> getAllByPage(Pageable pageable);
    /**
     * Devuelve una marca dado su ID
     * @param id identificador de la marca
     * @return devuelve un Optional de la marca
     */
    Optional<MarcaDto> getMarca(Long id);

    /**
     * Devuelve una marca dado su nombre
     * @param name nombre de la marca
     * @return devuelve un Optional de la marca
     */
    Optional<MarcaDto> getMarcaByName(String name);

    /**
     *Guarda una nueva marca de producto
     * @param newMarca marca a insertar en la base de datos
     * @return retorna la marca creada
     */
    MarcaDto save(MarcaDto newMarca);

    /**
     * Elimina una marca de base de datos
     *
     * @param id identifiacor de la marca a eliminar
     * @return
     */
    boolean delete(Long id);
}
