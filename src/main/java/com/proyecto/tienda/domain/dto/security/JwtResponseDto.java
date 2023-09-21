package com.proyecto.tienda.domain.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * dto de respuesta del token a mandar al frontend
 */
@Getter@Setter
@AllArgsConstructor
public class JwtResponseDto {
    private String jwt;
}
