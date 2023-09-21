package com.proyecto.tienda.domain.dto.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthClienteDto {
    private String username;
    private String password;
}
