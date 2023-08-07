package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.cliente.ClientePojo;
import com.proyecto.tienda.domain.pojo.security.AuthClientePojo;
import com.proyecto.tienda.domain.pojo.security.JwtResponsePojo;
import com.proyecto.tienda.domain.repository.IClienteRepository;
import com.proyecto.tienda.domain.usecase.IAuthUseCase;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import com.proyecto.tienda.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthUseCase {
    /**
     * Repositorio del cliente
     */
    private final IClienteRepository iClienteRepository;

    /**
     * Clase de gestion con JWT
     */
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    /**
     * Clase de ecriptamiento
     */
    private final PasswordEncoder passwordEncoder;

    final String NOT_EXISTS_MESSAGE = "El cliente no se encuentra registrado en la base de datos";

    final String INCORRECT_PASSWORD_MESSAGE= "Contraseña incorrecta";


    /**
     * @param authClientePojo
     * @return JwtResponsePojo del token creado para el cliente
     */
    @Override
    public JwtResponsePojo signIn(AuthClientePojo authClientePojo) {
        Optional<ClientePojo> cliente = iClienteRepository.getByUsername(authClientePojo.getUsername());
        if (cliente.isEmpty()){
            throw new ErrorValidationExceptions(this.NOT_EXISTS_MESSAGE);
        }
        if (!passwordEncoder.matches(authClientePojo.getPassword(),cliente.get().getPassword())){
            throw new ErrorValidationExceptions(this.INCORRECT_PASSWORD_MESSAGE);
        }
        String token = jwtAuthenticationProvider.createToken(cliente.get());
        return new JwtResponsePojo(token);
    }

    /**
     * @param jwt token a destrurir
     * @return respuesta
     */
    @Override
    public JwtResponsePojo signOut(String jwt) {
        String[] authElements = jwt.split(" ");//se separa el bearer del token
        return new JwtResponsePojo(jwtAuthenticationProvider.deleteToken(authElements[1]));//el segundo elemento es el token
    }
}
