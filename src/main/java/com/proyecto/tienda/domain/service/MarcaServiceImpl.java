package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.MarcaPojo;
import com.proyecto.tienda.domain.repository.IMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de la marca
 */
@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements IMarcaService {

    /**
     * Obtiene la lista de la tabla de marcas
     * repositorio de la marca
     */
    private final IMarcaRepository iMarcaRepository;

    /**
     * @return retorna una lista con todas la Marcas de los productos
     */
    @Transactional(readOnly = true)
    @Override
    public List<MarcaPojo> getAll() {
        return iMarcaRepository.getAll();
    }

    /**
     * Devuelve una marca a partir de su ID
     *
     * @param id identificador de la marca
     * @return devuelve el optional casteando a un pojo la entidad
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<MarcaPojo> getMarca(Long id) {
        return iMarcaRepository.getMarca(id);
    }

    /**
     * Guarda una nueva marca de producto
     *
     * @param newMarca marca a insertar en la base de datos
     * @return retorna la marca creada
     */
    @Transactional
    @Override
    public Optional<MarcaPojo> save(MarcaPojo newMarca) {
        if (iMarcaRepository.getMarca(newMarca.getId()).isEmpty()){
            return Optional.of(iMarcaRepository.save(newMarca));
        }
        return Optional.empty();

    }

    /**
     * actualiza una marca
     *
     * @param marca marca a actualizar en la base de datos
     * @return retorna un optional que contendra la marca(si existe)
     */
    @Override
    public Optional<MarcaPojo> update(MarcaPojo marca) {
        if (iMarcaRepository.getMarca(marca.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iMarcaRepository.save(marca));
    }

    /**
     * Elimina una marca de base de datos
     *
     * @param id de la marca a eliminar
     * @return true si se elimina, false simo
     */

    @Transactional
    @Override
    public boolean delete(Long id) {
        if (iMarcaRepository.getMarca(id).isEmpty()) {
            return false;
        }
        iMarcaRepository.delete(id);
        return true;
    }
}
