package com.proyecto.tienda.persistance.mapper.marca;

import com.proyecto.tienda.domain.pojo.marca.MarcaIdPojo;
import com.proyecto.tienda.persistance.entity.MarcaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarcaIdMapper {

    @Mapping(target = "name", ignore = true)
    MarcaEntity toMarcaEntity(MarcaIdPojo marcaIdPojo);

    MarcaIdPojo toMarcaIdPojo(MarcaEntity marcaEntity);

    List<MarcaIdPojo> toMarcasPojo(List<MarcaEntity> marcasEntityList);
}
