package com.proyecto.tienda.persistance.mapper.tipo;

import com.proyecto.tienda.domain.pojo.tipo.TipoPojo;
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
     * @param tipoPojo pojo a convertir
     * @return Entidad convertida
     */

    @Mapping(source = "marcas",target = "marcasEntities")
    @Mapping(target = "productos", ignore = true)
    TipoEntity toTipoEntity(TipoPojo tipoPojo);

    /**
     * Convierte una entidad a pojo
     *
     * @param tipoEntity Entidad a convertir
     * @return Pojo mapeado
     */

    @Mapping(source = "marcasEntities",target = "marcas")
    TipoPojo toTipoPojo(TipoEntity tipoEntity);

    /**
     * Convierte una lista de tipos de entidades a Pojos
     *
     * @param tipoEntities Lista de entidades de los tipos
     * @return Lista de pojos mapeada
     */
    List<TipoPojo> toTipoPojos(List<TipoEntity> tipoEntities);
}
