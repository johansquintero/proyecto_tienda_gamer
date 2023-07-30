package com.proyecto.tienda.persistance.mapper;

import com.proyecto.tienda.domain.pojo.TipoPojo;
import com.proyecto.tienda.persistance.entity.TipoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITipoMapper {

    /**
     * Convierte una entidad a pojo
     * @param tipoEntity Entidad a convertir
     * @return Pojo mapeado
     */

    TipoPojo toTipoPojo(TipoEntity tipoEntity);

    /**
     * Convierte un Pojo a una entidad
     * @param tipoPojo pojo a convertir
     * @return Entidad convertida
     */
    @Mapping(target = "productos",ignore = true)
    TipoEntity toTipoEtity(TipoPojo tipoPojo);

    /**
     * Convierte una lista de tipos de entidades a Pojos
     * @param tipoEntities Lista de entidades de los tipos
     * @return Lista de pojos mapeada
     */
    List<TipoPojo> toTipoPojos(List<TipoEntity> tipoEntities);
}
