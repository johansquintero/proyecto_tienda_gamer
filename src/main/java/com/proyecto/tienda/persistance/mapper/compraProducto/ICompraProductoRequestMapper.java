package com.proyecto.tienda.persistance.mapper.compraProducto;

import com.proyecto.tienda.domain.dto.compraproducto.CompraProductoRequestDto;
import com.proyecto.tienda.persistance.entity.CompraProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICompraProductoRequestMapper {
    /**
     * Mapper para CompraProductoRequestDto a CompraProductoEntity
     * se ignoran los atributos de las relaciones y el id de la compra, ya que desde el frontend solo se envia el id del producto
     */
    @Mapping(source = "productId", target = "id.productId")
    @Mapping(target = "compraEntity", ignore = true)
    @Mapping(target = "productoEntity", ignore = true)
    @Mapping(target = "id.purchaseId", ignore = true)
    CompraProductoEntity toCompraProductoEntityByRequest(CompraProductoRequestDto compraProductoRequestDto);


}
