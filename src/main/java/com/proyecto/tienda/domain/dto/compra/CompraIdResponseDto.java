package com.proyecto.tienda.domain.dto.compra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * dto de respuesta del id de la compra(referencia de la factura)
 */

@Getter
@Setter
@AllArgsConstructor
public class CompraIdResponseDto {
    private Long id;
}
