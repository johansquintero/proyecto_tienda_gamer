package com.proyecto.tienda.persistance.mapper.cart;

import com.proyecto.tienda.domain.dto.cart.CartRequestDto;
import com.proyecto.tienda.persistance.entity.CartEntity;
import com.proyecto.tienda.persistance.mapper.producto.IProductoRequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {IProductoRequestMapper.class})
public interface ICartRequestMapper {

    @Mapping(target = "cliente", ignore = true)
    CartEntity toCartEntity(CartRequestDto cartRequestDto);

}
