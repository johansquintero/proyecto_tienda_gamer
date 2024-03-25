package com.proyecto.tienda.domain.dto.cart;

import com.proyecto.tienda.domain.dto.producto.ProductoRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequestDto {
    private Long id;
    private Long customerId;
    private List<ProductoRequestDto> productos;
}
