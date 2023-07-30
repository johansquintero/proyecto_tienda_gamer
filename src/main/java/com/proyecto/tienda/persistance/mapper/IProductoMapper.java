package com.proyecto.tienda.persistance.mapper;

import com.proyecto.tienda.domain.pojo.ProductoPojo;
import com.proyecto.tienda.persistance.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductoMapper {


    ProductoPojo toProductoPojo(ProductoEntity productoEntity);

    @Mapping(target = "tipo", ignore = true)
    ProductoEntity toProductoEntity(ProductoPojo productoPojo);

    List<ProductoPojo> toProductosPojos(List<ProductoEntity> productoEntities);
}
