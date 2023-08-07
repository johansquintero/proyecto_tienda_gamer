package com.proyecto.tienda.persistance.mapper.compra;

import com.proyecto.tienda.domain.pojo.compra.CompraRequestPojo;
import com.proyecto.tienda.persistance.entity.CompraEntity;
import com.proyecto.tienda.persistance.mapper.compraProducto.ICompraProductoRequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper de compras que a su vez usa los metodos de la interfaz ICompraProductoRequestMapper
 */
@Mapper(componentModel = "spring", uses = {ICompraProductoRequestMapper.class})
public interface ICompraRequestMapper {
    @Mapping(target = "clienteEntity", ignore = true)
    CompraEntity toCompraEntity(CompraRequestPojo compraRequestPojo);
}
