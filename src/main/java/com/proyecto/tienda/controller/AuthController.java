package com.proyecto.tienda.controller;


import com.proyecto.tienda.domain.pojo.cliente.ClientePojo;
import com.proyecto.tienda.domain.pojo.cliente.ClienteResponsePojo;
import com.proyecto.tienda.domain.pojo.security.AuthClientePojo;
import com.proyecto.tienda.domain.pojo.security.JwtResponsePojo;
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
    public ResponseEntity<ClienteResponsePojo> register(@RequestBody ClientePojo newCliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(iClienteUseCase.save(newCliente));
    }
    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponsePojo> signIn(@RequestBody AuthClientePojo authClientePojo){
        return ResponseEntity.ok(iAuthUseCase.signIn(authClientePojo));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponsePojo> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt){
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
