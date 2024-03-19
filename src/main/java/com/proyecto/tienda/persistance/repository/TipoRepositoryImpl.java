package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.dto.tipo.TipoDto;
import com.proyecto.tienda.domain.repository.ITipoRepository;
import com.proyecto.tienda.persistance.crud.ITipoCrudRepository;
import com.proyecto.tienda.persistance.entity.TipoEntity;
import com.proyecto.tienda.persistance.mapper.tipo.ITipoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
     * @param pageable
     * @return
     */
    @Override
    public Page<TipoDto> getAllByPage(Pageable pageable) {
        return this.iTipoCrudRepository.findAll(pageable).map(tipoEntity -> {
            return this.iTipoMapper.toTipoDto(tipoEntity);
        });
    }

    /**
     * Mapper de los tipos
     */
    private final ITipoMapper iTipoMapper;


    /**
     * @return retorna una lista con todas las tipos de producto
     */
    @Override
    public List<TipoDto> getAll() {
        return iTipoMapper.toTiposDto(iTipoCrudRepository.findAll());
    }

    /**
     * Devuelve un tipo dado su ID
     *
     * @param id identificador del tipo
     * @return devuelve un Optional del tipo
     */
    @Override
    public Optional<TipoDto> getTipo(Long id) {
        return iTipoCrudRepository.findById(id).map(iTipoMapper::toTipoDto);
    }

    /**
     * Devuelve un tipo a partir de su nombre
     *
     * @param name
     * @return Optional del tipo encontrado
     */
    @Override
    public Optional<TipoDto> getByName(String name) {
        return iTipoCrudRepository.findByName(name).map(iTipoMapper::toTipoDto);
    }

    /**
     * Guarda un nuevo tipo de producto
     *
     * @param newTipo tipo a insertar en la base de datos
     * @return retorna el tipo creado
     */
    @Override
    public TipoDto save(TipoDto newTipo) {
        return this.iTipoMapper.toTipoDto(this.iTipoCrudRepository.save(this.iTipoMapper.toTipoEntity(newTipo)));
    }

    /**
     * Elimina un tipo de base de datos
     *
     * @param id identifiacor del tipo a eliminar
     * @return boolean que confirma la eliminacion del elemento
     */
    @Override
    public boolean delete(Long id) {
        Optional<TipoEntity> tipoEntityOptional = this.iTipoCrudRepository.findById(id);
        if (tipoEntityOptional.isPresent()){
            TipoEntity tipoEntity = tipoEntityOptional.get();
            if (!tipoEntity.getMarcasEntities().isEmpty()){
                tipoEntity.getMarcasEntities().forEach(marcaEntity -> marcaEntity.getTiposEntities().remove(tipoEntity));
            }
            iTipoCrudRepository.delete(tipoEntity);
            return true;
        }
        return false;

    }
}
