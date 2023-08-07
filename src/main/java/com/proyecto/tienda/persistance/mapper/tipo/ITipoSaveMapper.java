package com.proyecto.tienda.persistance.mapper.tipo;

import com.proyecto.tienda.domain.pojo.tipo.TipoSavePojo;
import com.proyecto.tienda.persistance.entity.TipoEntity;
import com.proyecto.tienda.persistance.mapper.marca.IMarcaIdMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IMarcaIdMapper.class})
public interface ITipoSaveMapper {


    @Mapping(source = "marcasEntities", target = "marcaIdPojoList")
    TipoSavePojo toTipoPojo(TipoEntity tipoEntity);

    @Mapping(source = "marcaIdPojoList", target = "marcasEntities")
    @Mapping(target = "productos", ignore = true)
    TipoEntity toTipoEntity(TipoSavePojo tipoSavePojo);

    List<TipoSavePojo> toTipoSavePojos(List<TipoEntity> tipoEntities);
}

