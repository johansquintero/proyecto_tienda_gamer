package com.proyecto.tienda.persistance.mapper.producto;

import com.proyecto.tienda.domain.pojo.producto.ProductoRequestDto;
import com.proyecto.tienda.persistance.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductoRequestMapper {
    @Mapping(target = "tipo", ignore = true)
    @Mapping(target = "marca", ignore = true)
    @Mapping(target = "compraProductos", ignore = true)
    ProductoEntity toProductoEntity(ProductoRequestDto productoRequestDto);
}
