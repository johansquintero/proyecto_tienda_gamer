package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.cart.CartRequestDto;
import com.proyecto.tienda.domain.dto.cart.CartResponseDto;
import com.proyecto.tienda.domain.repository.ICartRepository;
import com.proyecto.tienda.domain.usecase.ICartUseCase;
import com.proyecto.tienda.exception.ErrorAlertMessages;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements ICartUseCase {
    private final ICartRepository iCartRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<CartResponseDto> getCartById(Long id) {
        var cart = this.iCartRepository.getCartById(id);
        if (cart.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.CART_NOT_EXISTS_MESSAGE);
        }
        return cart;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<CartResponseDto> getCartByCustomerId(Long id) {
        var cart = this.iCartRepository.getCartByCustomerId(id);
        if (cart.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.CART_NOT_EXISTS_MESSAGE);
        }
        return cart;
    }

    /**
     * @param cartRequestDto
     * @return
     */
    @Override
    public Optional<CartResponseDto> save(CartRequestDto cartRequestDto) {
        var cart = this.iCartRepository.getCartByCustomerId(cartRequestDto.getCustomerId());
        if (!cart.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.CART_ALREADY_EXISTS_MESSAGE);
        }
        return this.iCartRepository.save(cartRequestDto);
    }

    /**
     * @param cartRequestDto
     * @return
     */
    @Override
    public Optional<CartResponseDto> update(CartRequestDto cartRequestDto) {
        var cart = this.iCartRepository.getCartById(cartRequestDto.getId());
        if (cart.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.CART_NOT_EXISTS_MESSAGE);
        }
        return this.iCartRepository.save(cartRequestDto);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean delete(Long id) {
        var cart = this.iCartRepository.getCartById(id);
        if (cart.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.CART_NOT_EXISTS_MESSAGE);
        }
        this.iCartRepository.delete(id);
        return true;
    }
}
