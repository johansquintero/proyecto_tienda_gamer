package com.proyecto.tienda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllersExceptions {
    @ExceptionHandler(ClienteValidationExceptions.class)
    public ResponseEntity<Map<String, String>> clienteException(ClienteValidationExceptions clienteValidationExceptions) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("ERROR", clienteValidationExceptions.getMessage()));
    }
    @ExceptionHandler(TipoValidationExceptions.class)
    public ResponseEntity<Map<String, String>> tipoException(TipoValidationExceptions tipoValidationExceptions){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("ERROR",tipoValidationExceptions.getMessage()));
    }
}
