package com.proyecto.tienda.controller;


import com.proyecto.tienda.domain.dto.cliente.ClienteDto;
import com.proyecto.tienda.domain.dto.cliente.ClienteResponseDto;
import com.proyecto.tienda.domain.dto.security.AuthClienteDto;
import com.proyecto.tienda.domain.dto.security.JwtResponseDto;
import com.proyecto.tienda.domain.usecase.IAuthUseCase;
import com.proyecto.tienda.domain.usecase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final IAuthUseCase iAuthUseCase;
    private final IClienteUseCase iClienteUseCase;

    @PostMapping(path = "/register")
    public ResponseEntity<ClienteResponseDto> register(@RequestBody ClienteDto newCliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(iClienteUseCase.save(newCliente));
    }
    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthClienteDto authClienteDto){
        return ResponseEntity.ok(iAuthUseCase.signIn(authClienteDto));
    }

    @DeleteMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt){
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
