package com.proyecto.tienda.persistance.mapper;

import com.proyecto.tienda.domain.pojo.CompraProductoRequestPojo;
import com.proyecto.tienda.domain.pojo.CompraProductoResponsePojo;
import com.proyecto.tienda.persistance.entity.CompraProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICompraProductoRequestMapper {
    /**
     * Mapper para CompraProductoRequestPojo a CompraProductoEntity
     * se ignoran los atributos de las relaciones y el id de la compra, ya que desde el frontend solo se envia el id del producto
     */
    @Mapping(source = "productId", target = "id.productId")
    @Mapping(target = "compraEntity", ignore = true)
    @Mapping(target = "productoEntity", ignore = true)
    @Mapping(target = "id.purchaseId", ignore = true)
    CompraProductoEntity toCompraProductoEntityByRequest(CompraProductoRequestPojo compraProductoRequestPojo);


}
