package com.proyecto.tienda.persistance.mapper.marca;

import com.proyecto.tienda.domain.pojo.marca.MarcaPojo;
import com.proyecto.tienda.persistance.entity.MarcaEntity;
import com.proyecto.tienda.persistance.mapper.tipo.ITipoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que tranforma objetos de marca a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IMarcaMapper{

    /**
     * Convierte un Pojo a una entidad
     * @param marcaPojo pojo a convertir
     * @return Entidad convertida
     */
    @Mapping(target = "tiposEntities",ignore = true)
    @Mapping(target = "productos",ignore = true)
    MarcaEntity toMarcaEntity(MarcaPojo marcaPojo);

    /**
     * Convierte una entidad marca a marca pojo
     * @param marcaEntity Entidad a convertir
     * @return Pojo mapeado
     */

    MarcaPojo toMarcaPojo(MarcaEntity marcaEntity);

    /**
     * Convierte una lista de marcas de entidades a Pojos
     * @param marcasEntityList Lista de entidades de marcas
     * @return Lista de pojos mapped
     */
    List<MarcaPojo> toMarcaPojos(List<MarcaEntity> marcasEntityList);
}

