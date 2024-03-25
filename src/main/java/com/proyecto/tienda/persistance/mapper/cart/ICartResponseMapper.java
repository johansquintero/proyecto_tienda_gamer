package com.proyecto.tienda.persistance.mapper.cart;

import com.proyecto.tienda.domain.dto.cart.CartResponseDto;
import com.proyecto.tienda.persistance.entity.CartEntity;
import com.proyecto.tienda.persistance.mapper.producto.IProductoResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {IProductoResponseMapper.class})
public interface ICartResponseMapper {
    CartResponseDto toCartResponseDto(CartEntity cartEntity);
}
