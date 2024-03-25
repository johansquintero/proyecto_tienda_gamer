package com.proyecto.tienda.persistance.mapper.compraProducto;

import com.proyecto.tienda.domain.dto.compraproducto.CompraProductoResponseDto;
import com.proyecto.tienda.persistance.entity.CompraProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * Mapper para los CompraProductoResponseDto
 * Solo se mapean el nombre del producto, la cantidad y el total
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICompraProductoResponseMapper {

    @Mapping(target = "compraEntity", ignore = true)
    @Mapping(target = "productoEntity", ignore = true)
    @Mapping(target = "id.purchaseId", ignore = true)
    @Mapping(target = "id.productId", ignore = true)
    CompraProductoEntity toCompraProductoEntityByResponse(CompraProductoResponseDto compraProductoResponseDto);

    @Mapping(source = "productoEntity.name", target = "productName")
    CompraProductoResponseDto toCompraResponseDto(CompraProductoEntity compraProductoEntity);
}
