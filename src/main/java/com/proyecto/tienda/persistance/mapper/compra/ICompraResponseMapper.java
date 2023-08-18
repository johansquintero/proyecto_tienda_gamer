package com.proyecto.tienda.persistance.mapper.compra;

import com.proyecto.tienda.domain.pojo.compra.CompraResponsePojo;
import com.proyecto.tienda.persistance.entity.CompraEntity;
import com.proyecto.tienda.persistance.mapper.compraProducto.ICompraProductoResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para el response
 */
@Mapper(componentModel = "spring",uses = {ICompraProductoResponseMapper.class})
public interface ICompraResponseMapper {

    @Mapping(target = "clienteEntity", ignore = true)
    CompraEntity toCompraEntity(CompraResponsePojo compraResponsePojo);

    CompraResponsePojo toCompraResponsePojo(CompraEntity compraEntity);

    List<CompraResponsePojo> toComprasResponsePojo(List<CompraEntity> comprasEntitie);
}
