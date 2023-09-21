package com.proyecto.tienda.persistance.mapper.compra;

import com.proyecto.tienda.domain.dto.compra.CompraResponseDto;
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
    CompraEntity toCompraEntity(CompraResponseDto compraResponseDto);

    CompraResponseDto toCompraResponseDto(CompraEntity compraEntity);

    List<CompraResponseDto> toComprasResponseDto(List<CompraEntity> comprasEntitie);
}
