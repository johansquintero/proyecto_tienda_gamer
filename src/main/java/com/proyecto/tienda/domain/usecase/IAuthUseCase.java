package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.pojo.security.AuthClientePojo;
import com.proyecto.tienda.domain.pojo.security.JwtResponsePojo;

public interface IAuthUseCase {
    JwtResponsePojo signIn(AuthClientePojo authClientePojo);
    JwtResponsePojo signOut(String jwt);
}
