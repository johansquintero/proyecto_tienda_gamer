package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.dto.cart.CartRequestDto;
import com.proyecto.tienda.domain.dto.cart.CartResponseDto;

import java.util.Optional;

public interface ICartUseCase {
    Optional<CartResponseDto> getCartById(Long id);
    Optional<CartResponseDto> getCartByCustomerId(Long id);
    Optional<CartResponseDto> save(CartRequestDto cartRequestDto);

    Optional<CartResponseDto> update(CartRequestDto cartRequestDto);
    boolean delete(Long id);
}
