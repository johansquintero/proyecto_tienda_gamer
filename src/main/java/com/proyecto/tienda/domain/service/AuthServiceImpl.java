package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.cliente.ClienteDto;
import com.proyecto.tienda.domain.dto.security.AuthClienteDto;
import com.proyecto.tienda.domain.dto.security.JwtResponseDto;
import com.proyecto.tienda.domain.repository.IClienteRepository;
import com.proyecto.tienda.domain.usecase.IAuthUseCase;
import com.proyecto.tienda.exception.ErrorAlertMessages;
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

    /**
     * @param authClienteDto
     * @return JwtResponseDto del token creado para el cliente
     */
    @Override
    public JwtResponseDto signIn(AuthClienteDto authClienteDto) {
        Optional<ClienteDto> cliente = iClienteRepository.getByUsername(authClienteDto.getUsername());
        if (cliente.isEmpty()){
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_NOT_EXISTS_MESSAGE);
        }
        if (!passwordEncoder.matches(authClienteDto.getPassword(),cliente.get().getPassword())){
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_INCORRECT_PASSWORD_MESSAGE);
        }
        String token = jwtAuthenticationProvider.createToken(cliente.get());
        return new JwtResponseDto(token);
    }

    /**
     * @param jwt token a destrurir
     * @return respuesta
     */
    @Override
    public JwtResponseDto signOut(String jwt) {
        String[] authElements = jwt.split(" ");//se separa el bearer del token
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(authElements[1]));//el segundo elemento es el token
    }
}
