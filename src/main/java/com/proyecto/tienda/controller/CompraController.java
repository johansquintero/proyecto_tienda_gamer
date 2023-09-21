package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.dto.compra.CompraIdResponseDto;
import com.proyecto.tienda.domain.dto.compra.CompraRequestDto;
import com.proyecto.tienda.domain.dto.compra.CompraResponseDto;
import com.proyecto.tienda.domain.dto.compraproducto.CompraProductoRequestDto;
import com.proyecto.tienda.domain.usecase.ICompraUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/compras")
public class CompraController {
    private final ICompraUseCase iCompraUseCase;

    @GetMapping
    public ResponseEntity<List<CompraResponseDto>> getAll(){
        return ResponseEntity.ok(iCompraUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompraResponseDto> getCompra(@PathVariable Long id){
        return ResponseEntity.of(iCompraUseCase.getCompra(id));
    }

    @GetMapping(path = "/cliente/{customerId}")
    public ResponseEntity<List<CompraResponseDto>> getCompraByCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(iCompraUseCase.getAllByCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<CompraIdResponseDto> save(@RequestBody CompraRequestDto compraNewRequestPojo){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCompraUseCase.save(compraNewRequestPojo));
    }
}
