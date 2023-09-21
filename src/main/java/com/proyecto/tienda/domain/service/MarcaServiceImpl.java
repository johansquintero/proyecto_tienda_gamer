package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.marca.MarcaDto;
import com.proyecto.tienda.domain.repository.IMarcaRepository;
import com.proyecto.tienda.domain.usecase.IMarcaUseCase;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    @Override
    public List<MarcaDto> getAll() {
        return iMarcaRepository.getAll();
    }

    /**
     * Devuelve una marca a partir de su ID
     *
     * @param id identificador de la marca
     * @return devuelve el optional casteando a un dto la entidad
     */
    @Override
    public Optional<MarcaDto> getMarca(Long id) {
        Optional<MarcaDto> marcaOptional = iMarcaRepository.getMarca(id);
        if (marcaOptional.isEmpty()) {
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
    @Override
    public MarcaDto save(MarcaDto newMarca) {
        if (iMarcaRepository.getMarcaByName(newMarca.getName()).isPresent()) {
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
    @Override
    public Optional<MarcaDto> update(MarcaDto marca) {
        Optional<MarcaDto> optionalMarcaPojo = iMarcaRepository.getMarca(marca.getId());
        if (optionalMarcaPojo.isEmpty()) {
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        optionalMarcaPojo = iMarcaRepository.getMarcaByName(marca.getName());
        if (optionalMarcaPojo.isPresent() && marca.getId() != optionalMarcaPojo.get().getId()) {
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

    @Override
    public boolean delete(Long id) {
        return iMarcaRepository.delete(id);
    }
}
