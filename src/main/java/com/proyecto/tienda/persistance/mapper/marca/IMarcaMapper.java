package com.proyecto.tienda.persistance.mapper.marca;

import com.proyecto.tienda.domain.pojo.marca.MarcaPojo;
import com.proyecto.tienda.persistance.entity.MarcaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que tranforma objetos de marca a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IMarcaMapper {

    /**
     * Convierte una entidad marca a marca pojo
     * @param marcaEntity Entidad a convertir
     * @return Pojo mapeado
     */
    @Mapping(source = "id", target = "id")
    MarcaPojo toMarcaPojo(MarcaEntity marcaEntity);

    /**
     * Convierte un Pojo a una entidad
     * @param marcaPojo pojo a convertir
     * @return Entidad convertida
     */
    @InheritInverseConfiguration
    MarcaEntity toMarcaEntity(MarcaPojo marcaPojo);

    /**
     * Convierte una lista de marcas de entidades a Pojos
     * @param marcasEntityList Lista de entidades de marcas
     * @return Lista de pojos mapped
     */
    List<MarcaPojo> toMarcasPojo(List<MarcaEntity> marcasEntityList);
}
