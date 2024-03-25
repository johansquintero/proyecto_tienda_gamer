package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.dto.cart.CartRequestDto;
import com.proyecto.tienda.domain.dto.cart.CartResponseDto;
import com.proyecto.tienda.domain.usecase.ICartUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping(path = "/carrito")
@RestController

public class CartController {
    private final ICartUseCase iCartUseCase;

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<CartResponseDto> getById(@PathVariable(name="id") Long id){
        return ResponseEntity.of(iCartUseCase.getCartById(id));
    }
    @GetMapping(path = "/customer-id/{id}")
    public ResponseEntity<CartResponseDto> getByCustomerId(@PathVariable(name="id") Long id){
        return ResponseEntity.of(iCartUseCase.getCartByCustomerId(id));
    }

    @PutMapping
    public ResponseEntity<CartResponseDto> getByCustomerId(@RequestBody CartRequestDto cartRequestDto){
        return ResponseEntity.of(iCartUseCase.update(cartRequestDto));
    }
}
