package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.dto.marca.MarcaDto;
import com.proyecto.tienda.domain.repository.IMarcaRepository;
import com.proyecto.tienda.persistance.entity.MarcaEntity;
import com.proyecto.tienda.persistance.mapper.marca.IMarcaMapper;
import com.proyecto.tienda.persistance.crud.IMarcaCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementacion del la interfaz del repositorio  de la marca en donde se mapearan las consultas a un dominio
 */
@Repository
@RequiredArgsConstructor//crear el constructor para las variables final
public class MarcaRepositoryImpl implements IMarcaRepository {

    /**
     * Crud de la marca
     */
    private final IMarcaCrudRepository iMarcaCrudRepository;
    /**
     * Mapper de la marca
     */
    private final IMarcaMapper iMarcaMapper;

    /**
     * @return retorna una lista con todas la Marcas de los productos
     */
    @Transactional(readOnly = true)
    @Override
    public List<MarcaDto> getAll() {
        return iMarcaMapper.toMarcasDto(iMarcaCrudRepository.findAll());
    }

    /**
     *
     * @param pageable
     * @return retorna la pagina solicitada
     */
    @Transactional(readOnly = true)
    @Override
    public Page<MarcaDto> getAllByPage(Pageable pageable){
        return this.iMarcaCrudRepository.findAll(pageable).map(marcaEntity -> {
           return this.iMarcaMapper.toMarcaDto(marcaEntity);
        });
    }
    /**
     * Devuelve una marca a partir de su ID
     * @param id identificador de la marca
     * @return devuelve el optional casteando a un dto la entidad
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<MarcaDto> getMarca(Long id) {
        return iMarcaCrudRepository.findById(id).map(iMarcaMapper::toMarcaDto);//map corto
    }

    /**
     * Devuelve una marca dado su nombre
     *
     * @param name nombre de la marca
     * @return devuelve un Optional de la marca
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<MarcaDto> getMarcaByName(String name) {
        return iMarcaCrudRepository.findByName(name).map(iMarcaMapper::toMarcaDto);
    }

    /**
     *Guarda una nueva marca de producto
     * @param newMarca marca a insertar en la base de datos
     * @return retorna la marca creada
     */
    @Transactional
    @Override
    public MarcaDto save(MarcaDto newMarca) {
        MarcaEntity marcaEntity = iMarcaMapper.toMarcaEntity(newMarca);
        return iMarcaMapper.toMarcaDto(iMarcaCrudRepository.save(marcaEntity));
    }

    /**
     * Elimina una marca de base de datos
     *
     * @param id de la marca a eliminar
     * @return booleano que valida la existencia del elemento
     */
    @Transactional
    @Override
    public boolean delete(Long id) {
        Optional<MarcaEntity> marcaEntityOptional = iMarcaCrudRepository.findById(id);
        if (marcaEntityOptional.isPresent()){
            MarcaEntity marcaEntity= marcaEntityOptional.get();
            if (!marcaEntity.getTiposEntities().isEmpty()){
                //elimina la marca en cada uno de los tipos relacionados a esta
                marcaEntity.getTiposEntities().forEach(tipoEntity -> tipoEntity.getMarcasEntities().remove(marcaEntity));
            }
            iMarcaCrudRepository.delete(marcaEntity);
            return true;
        }
        return false;
    }
}
