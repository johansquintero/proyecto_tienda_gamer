package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.TipoPojo;
import com.proyecto.tienda.domain.repository.ITipoRepository;
import com.proyecto.tienda.exception.TipoValidationExceptions;
import com.proyecto.tienda.domain.usecase.ITipoUseCase;
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

    private final String EXISTS_MESSAGE = "El tipo deproducto ya se encuentra registrado";


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
        return iTipoRepository.getTipo(id);
    }

    /**
     * Guarda un nuevo tipo de producto
     *
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    @Transactional
    @Override
    public TipoPojo save(TipoPojo newTipo) {
        if (iTipoRepository.getByName(newTipo.getName()).isPresent()){
            throw new TipoValidationExceptions(this.EXISTS_MESSAGE);
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
    public Optional<TipoPojo> update(TipoPojo tipo) {
        if (iTipoRepository.getTipo(tipo.getId()).isEmpty()){
            return Optional.empty();
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
        if (iTipoRepository.getTipo(id).isEmpty()){
            return false;
        }
        iTipoRepository.delete(id);
        return true;
    }
}
