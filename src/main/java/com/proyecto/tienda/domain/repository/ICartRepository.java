package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.dto.cart.CartRequestDto;
import com.proyecto.tienda.domain.dto.cart.CartResponseDto;

import java.util.Optional;

public interface ICartRepository {
    Optional<CartResponseDto> getCartById(Long id);

    Optional<CartResponseDto> getCartByCustomerId(Long id);
    Optional<CartResponseDto> save(CartRequestDto cartRequestDto);

    void delete(Long id);
}
