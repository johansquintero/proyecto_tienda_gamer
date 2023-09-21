package com.proyecto.tienda.persistance.mapper.tipo;

import com.proyecto.tienda.domain.dto.tipo.TipoDto;
import com.proyecto.tienda.persistance.entity.TipoEntity;
import com.proyecto.tienda.persistance.mapper.marca.IMarcaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {IMarcaMapper.class})
public interface ITipoMapper {


    /**
     * Convierte un Pojo a una entidad
     *
     * @param tipoDto dto a convertir
     * @return Entidad convertida
     */

    @Mapping(source = "marcas",target = "marcasEntities")
    @Mapping(target = "productos", ignore = true)
    TipoEntity toTipoEntity(TipoDto tipoDto);

    /**
     * Convierte una entidad a dto
     *
     * @param tipoEntity Entidad a convertir
     * @return Pojo mapeado
     */

    @Mapping(source = "marcasEntities",target = "marcas")
    TipoDto toTipoDto(TipoEntity tipoEntity);

    /**
     * Convierte una lista de tipos de entidades a Pojos
     *
     * @param tipoEntities Lista de entidades de los tipos
     * @return Lista de pojos mapeada
     */
    List<TipoDto> toTiposDto(List<TipoEntity> tipoEntities);
}
