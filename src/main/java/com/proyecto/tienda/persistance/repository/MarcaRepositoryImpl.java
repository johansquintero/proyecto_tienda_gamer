package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.pojo.MarcaPojo;
import com.proyecto.tienda.domain.repository.IMarcaRepository;
import com.proyecto.tienda.persistance.entity.MarcaEntity;
import com.proyecto.tienda.persistance.mapper.IMarcaMapper;
import com.proyecto.tienda.persistance.crud.IMarcaCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    @Override
    public List<MarcaPojo> getAll() {
        return iMarcaMapper.toMarcasPojo(iMarcaCrudRepository.findAll());
    }

    /**
     * Devuelve una marca a partir de su ID
     * @param id identificador de la marca
     * @return devuelve el optional casteando a un pojo la entidad
     */
    @Override
    public Optional<MarcaPojo> getMarca(Long id) {
        return iMarcaCrudRepository.findById(id).map(iMarcaMapper::toMarcaPojo);//map corto
    }

    /**
     *Guarda una nueva marca de producto
     * @param newMarca marca a insertar en la base de datos
     * @return retorna la marca creada
     */
    @Override
    public MarcaPojo save(MarcaPojo newMarca) {
        MarcaEntity marcaEntity = iMarcaMapper.toMarcaEntity(newMarca);
        return iMarcaMapper.toMarcaPojo(iMarcaCrudRepository.save(marcaEntity));
    }

    /**
     *Elimina una marca de base de datos
     * @param id de la marca a eliminar
     */
    @Override
    public void delete(Long id) {
        iMarcaCrudRepository.deleteById(id);
    }
}
