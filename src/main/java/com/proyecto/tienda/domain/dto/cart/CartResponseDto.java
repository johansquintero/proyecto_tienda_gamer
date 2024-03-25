package com.proyecto.tienda.domain.dto.cart;

import com.proyecto.tienda.domain.dto.producto.ProductoResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class CartResponseDto {
    private Long id;
    private Long customerId;
    private List<ProductoResponseDto> productos;
}
