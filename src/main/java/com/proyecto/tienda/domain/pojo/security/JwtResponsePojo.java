package com.proyecto.tienda.domain.pojo.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * dto de respuesta del token a mandar al frontend
 */
@Getter@Setter
@AllArgsConstructor
public class JwtResponsePojo {
    private String jwt;
}
