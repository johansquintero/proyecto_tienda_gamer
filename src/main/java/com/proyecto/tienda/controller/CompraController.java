package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.pojo.compra.CompraIdResponsePojo;
import com.proyecto.tienda.domain.pojo.compra.CompraRequestPojo;
import com.proyecto.tienda.domain.pojo.compra.CompraResponsePojo;
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
    public ResponseEntity<List<CompraResponsePojo>> getAll(){
        return ResponseEntity.ok(iCompraUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompraResponsePojo> getCompra(@PathVariable Long id){
        return ResponseEntity.of(iCompraUseCase.getCompra(id));
    }

    @GetMapping(path = "/cliente/{customerId}")
    public ResponseEntity<List<CompraResponsePojo>> getCompraByCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(iCompraUseCase.getAllByCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<CompraIdResponsePojo> save(@RequestBody CompraRequestPojo compraNewRequestPojo){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCompraUseCase.save(compraNewRequestPojo));
    }
}
