package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.dto.security.AuthClienteDto;
import com.proyecto.tienda.domain.dto.security.JwtResponseDto;

public interface IAuthUseCase {
    JwtResponseDto signIn(AuthClienteDto authClienteDto);
    JwtResponseDto signOut(String jwt);
}
