package com.proyecto.tienda.persistance.mapper.compraProducto;

import com.proyecto.tienda.domain.pojo.compraproducto.CompraProductoResponsePojo;
import com.proyecto.tienda.persistance.entity.CompraProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper para los CompraProductoResponsePojo
 * Solo se mapean el nombre del producto, la cantidad y el total
 */
@Mapper(componentModel = "spring")
public interface ICompraProductoResponseMapper {

    @Mapping(target = "compraEntity", ignore = true)
    @Mapping(target = "productoEntity", ignore = true)
    @Mapping(target = "id.purchaseId", ignore = true)
    @Mapping(target = "id.productId", ignore = true)
    CompraProductoEntity toCompraProductoEntityByResponse(CompraProductoResponsePojo compraProductoResponsePojo);

    @Mapping(source = "productoEntity.name", target = "productName")
    CompraProductoResponsePojo toCompraResponsePojo(CompraProductoEntity compraProductoEntity);
}
