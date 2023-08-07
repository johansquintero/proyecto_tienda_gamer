package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.tipo.TipoPojo;
import com.proyecto.tienda.domain.pojo.tipo.TipoSavePojo;
import com.proyecto.tienda.domain.repository.ITipoRepository;
import com.proyecto.tienda.domain.usecase.ITipoUseCase;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de los tipos
 */
@Service
@RequiredArgsConstructor
public class TipoUseServiceImpl implements ITipoUseCase {

    private final ITipoRepository iTipoRepository;

    final String EXISTS_MESSAGE = "El tipo de deproducto ya se encuentra registrado";
    final String NOT_EXISTS_MESSAGE = "El tipo de deproducto no se encuentra registrado";


    /**
     * @return retorna una lista con todas las tipos de producto
     */
    @Transactional(readOnly = true)
    @Override
    public List<TipoPojo> getAll() {
        return iTipoRepository.getAll();
    }

    /**
     * Devuelve un tipo dado su ID
     *
     * @param id identificador del tipo
     * @return devuelve un Optional del tipo
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<TipoPojo> getTipo(Long id) {
        Optional<TipoPojo> tipoOptional = iTipoRepository.getTipo(id);
        if (tipoOptional.isEmpty()) {
            throw new ErrorValidationExceptions(this.NOT_EXISTS_MESSAGE);
        }
        return tipoOptional;
    }

    /**
     * Guarda un nuevo tipo de producto
     *
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    @Transactional
    @Override
    public TipoSavePojo save(TipoSavePojo newTipo) {
        if (iTipoRepository.getByName(newTipo.getName()).isPresent()) {
            throw new ErrorValidationExceptions(this.EXISTS_MESSAGE);
        }
        return iTipoRepository.save(newTipo);
    }

    /**
     * actualiza un nuevo tipo de producto
     *
     * @param tipo tipo a actualizar en la base de datos
     * @return retorna el tipo creado
     */
    @Transactional
    @Override
    public Optional<TipoSavePojo> update(TipoSavePojo tipo) {
        if (iTipoRepository.getTipo(tipo.getId()).isEmpty()) {
            throw new ErrorValidationExceptions(this.NOT_EXISTS_MESSAGE);
        }
        return Optional.of(iTipoRepository.save(tipo));
    }

    /**
     * Elimina un tipo de base de datos
     *
     * @param id identifiacor del tipo a eliminar
     */
    @Transactional
    @Override
    public boolean delete(Long id) {
        if (iTipoRepository.getTipo(id).isEmpty()) {
            throw new ErrorValidationExceptions(this.NOT_EXISTS_MESSAGE);
        }
        iTipoRepository.delete(id);
        return true;
    }
}
