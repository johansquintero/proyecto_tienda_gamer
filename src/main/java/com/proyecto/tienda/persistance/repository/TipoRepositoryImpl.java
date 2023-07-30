package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.pojo.TipoPojo;
import com.proyecto.tienda.domain.repository.ITipoRepository;
import com.proyecto.tienda.persistance.crud.ITipoCrudRepository;
import com.proyecto.tienda.persistance.mapper.ITipoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementacion del la interfaz del repositorio  del tipo en donde se mapearan las consultas a un dominio
 */
@Repository
@RequiredArgsConstructor
public class TipoRepositoryImpl implements ITipoRepository {

    /**
     * Crud de la entidad tipo
     */
    private final ITipoCrudRepository iTipoCrudRepository;

    /**
     * Mapper de los tipos
     */
    private final ITipoMapper iTipoMapper;

    /**
     * @return retorna una lista con todas las tipos de producto
     */
    @Override
    public List<TipoPojo> getAll() {
        return iTipoMapper.toTipoPojos(iTipoCrudRepository.findAll());
    }

    /**
     * Devuelve un tipo dado su ID
     *
     * @param id identificador del tipo
     * @return devuelve un Optional del tipo
     */
    @Override
    public Optional<TipoPojo> getTipo(Long id) {
        return iTipoCrudRepository.findById(id).map(iTipoMapper::toTipoPojo);
    }

    /**
     * Devuelve un tipo a partir de su nombre
     *
     * @param nombre
     * @return Optional del tipo encontrado
     */
    @Override
    public Optional<TipoPojo> getByNombre(String nombre) {
        return iTipoCrudRepository.findByNombre(nombre).map(iTipoMapper::toTipoPojo);
    }

    /**
     * Guarda un nuevo tipo de producto
     *
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    @Override
    public TipoPojo save(TipoPojo newTipo) {
        return iTipoMapper.toTipoPojo(iTipoCrudRepository.save(iTipoMapper.toTipoEtity(newTipo)));
    }

    /**
     * Elimina un tipo de base de datos
     *
     * @param id identifiacor del tipo a eliminar
     */
    @Override
    public void delete(Long id) {
        iTipoCrudRepository.deleteById(id);
    }
}
