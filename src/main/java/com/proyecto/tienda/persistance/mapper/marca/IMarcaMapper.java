package com.proyecto.tienda.persistance.mapper.marca;

import com.proyecto.tienda.domain.dto.marca.MarcaDto;
import com.proyecto.tienda.persistance.entity.MarcaEntity;
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
     * @param marcaDto dto a convertir
     * @return Entidad convertida
     */
    @Mapping(target = "tiposEntities",ignore = true)
    @Mapping(target = "productos",ignore = true)
    MarcaEntity toMarcaEntity(MarcaDto marcaDto);

    /**
     * Convierte una entidad marca a marca dto
     * @param marcaEntity Entidad a convertir
     * @return Pojo mapeado
     */

    MarcaDto toMarcaDto(MarcaEntity marcaEntity);

    /**
     * Convierte una lista de marcas de entidades a Pojos
     * @param marcasEntityList Lista de entidades de marcas
     * @return Lista de pojos mapped
     */
    List<MarcaDto> toMarcasDto(List<MarcaEntity> marcasEntityList);
}

