package com.proyecto.tienda.persistance.mapper.producto;

import com.proyecto.tienda.domain.pojo.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.pojo.producto.ProductoResponseDto;
import com.proyecto.tienda.persistance.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductoResponseMapper {
    @Mapping(source = "tipo.name", target = "tipo")
    @Mapping(source = "marca.name", target = "marca")
    ProductoResponseDto toProductoResponseDto(ProductoEntity productoEntity);

    List<ProductoResponseDto> toProductosResponseDto(List<ProductoEntity> productoEntities);
}
