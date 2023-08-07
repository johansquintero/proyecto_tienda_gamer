package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.marca.MarcaPojo;
import com.proyecto.tienda.domain.repository.IMarcaRepository;
import com.proyecto.tienda.domain.usecase.IMarcaUseCase;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
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
public class MarcaServiceImpl implements IMarcaUseCase {

    /**
     * Obtiene la lista de la tabla de marcas
     * repositorio de la marca
     */
    private final IMarcaRepository iMarcaRepository;

    /**
     * Mensajes de error
     */
    final String MESAGGE_EXISTS = "La marca ya se encuentra registrada en la base de datos";
    final String MESAGGE_NOT_EXISTS = "La marca no se encuentra registrada en la base de datos";

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
        Optional<MarcaPojo> marcaOptional = iMarcaRepository.getMarca(id);
        if (marcaOptional.isEmpty()){
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
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
    public MarcaPojo save(MarcaPojo newMarca) {
        if(iMarcaRepository.getMarcaByName(newMarca.getName()).isPresent()){
            throw new ErrorValidationExceptions(this.MESAGGE_EXISTS);
        }
        return iMarcaRepository.save(newMarca);
    }

    /**
     * actualiza una marca
     *
     * @param marca marca a actualizar en la base de datos
     * @return retorna un optional que contendra la marca(si existe)
     */
    @Transactional
    @Override
    public Optional<MarcaPojo> update(MarcaPojo marca) {
        if (iMarcaRepository.getMarca(marca.getId()).isEmpty()) {
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        if(iMarcaRepository.getMarcaByName(marca.getName()).isPresent()){
            throw new ErrorValidationExceptions(this.MESAGGE_EXISTS);
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
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        iMarcaRepository.delete(id);
        return true;
    }
}
