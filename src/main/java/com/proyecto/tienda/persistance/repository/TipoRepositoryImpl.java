package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.pojo.tipo.TipoPojo;
import com.proyecto.tienda.domain.pojo.tipo.TipoSavePojo;
import com.proyecto.tienda.domain.repository.ITipoRepository;
import com.proyecto.tienda.persistance.crud.ITipoCrudRepository;
import com.proyecto.tienda.persistance.mapper.tipo.ITipoMapper;
import com.proyecto.tienda.persistance.mapper.tipo.ITipoSaveMapper;
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
     * Mapper para el request de los tipos
     */
    private final ITipoSaveMapper iTipoSaveMapper;

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
     * @param name
     * @return Optional del tipo encontrado
     */
    @Override
    public Optional<TipoPojo> getByName(String name) {
        return iTipoCrudRepository.findByName(name).map(iTipoMapper::toTipoPojo);
    }

    /**
     * Guarda un nuevo tipo de producto
     *
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    @Override
    public TipoSavePojo save(TipoSavePojo newTipo) {
        return iTipoSaveMapper.toTipoPojo(iTipoCrudRepository.save(iTipoSaveMapper.toTipoEntity(newTipo)));
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
