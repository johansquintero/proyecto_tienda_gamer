package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.tipo.TipoDto;
import com.proyecto.tienda.domain.repository.ITipoRepository;
import com.proyecto.tienda.domain.usecase.ITipoUseCase;
import com.proyecto.tienda.exception.ErrorAlertMessages;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de los tipos
 */
@Service
@RequiredArgsConstructor
public class TipoServiceImpl implements ITipoUseCase {

    private final ITipoRepository iTipoRepository;

    /**
     * @return retorna una lista con todas las tipos de producto
     */

    @Override
    public List<TipoDto> getAll() {
        return iTipoRepository.getAll();
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<TipoDto> getAllByPage(Pageable pageable) {
        return this.iTipoRepository.getAllByPage(pageable);
    }

    /**
     * Devuelve un tipo dado su ID
     *
     * @param id identificador del tipo
     * @return devuelve un Optional del tipo
     */
    @Override
    public Optional<TipoDto> getTipo(Long id) {
        Optional<TipoDto> tipoOptional = iTipoRepository.getTipo(id);
        if (tipoOptional.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.TYPE_NOT_EXISTS_MESSAGE);
        }
        return tipoOptional;
    }

    /**
     * Guarda un nuevo tipo de producto
     *
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    @Override
    public TipoDto save(TipoDto newTipo) {
        if (iTipoRepository.getByName(newTipo.getName()).isPresent()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.TYPE_ALREADY_EXISTS_MESSAGE);
        }
        return iTipoRepository.save(newTipo);
    }

    /**
     * actualiza un nuevo tipo de producto
     *
     * @param tipo tipo a actualizar en la base de datos
     * @return retorna el tipo creado
     */
    @Override
    public Optional<TipoDto> update(TipoDto tipo) {
        if (iTipoRepository.getTipo(tipo.getId()).isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.TYPE_NOT_EXISTS_MESSAGE);
        }
        return Optional.of(iTipoRepository.save(tipo));
    }

    /**
     * Elimina un tipo de base de datos
     *
     * @param id identifiacor del tipo a eliminar
     */
    @Override
    public boolean delete(Long id) {
        return iTipoRepository.delete(id);
    }
}
