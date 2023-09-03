package com.proyecto.tienda.controller;


import com.proyecto.tienda.domain.pojo.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.pojo.producto.ProductoResponseDto;
import com.proyecto.tienda.domain.usecase.IProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/productos")
public class ProductoContoller {
    private final IProductoUseCase iProductoUseCase;

    @GetMapping
    public ResponseEntity<List<ProductoResponseDto>> getAll(){
        return ResponseEntity.ok(iProductoUseCase.getAll());
    }

    @GetMapping(path = "/page/{page}")
    public Page<ProductoResponseDto> page(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 2);
        return iProductoUseCase.getPage(pageable);
    }

    @GetMapping(path = "/price/{price}")
    public ResponseEntity<List<ProductoResponseDto>> getByPrice(@PathVariable Double price){
        return ResponseEntity.ok(iProductoUseCase.getProductoByPrice(price));
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<ProductoResponseDto>> getByTitle(@PathVariable String name){
        return ResponseEntity.ok(iProductoUseCase.getProductosByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoResponseDto> getProducto(@PathVariable Long id){
        return ResponseEntity.of(iProductoUseCase.getProducto(id));
    }
    @PostMapping
    public ResponseEntity<ProductoResponseDto> save(@RequestBody ProductoRequestDto productoRequestDto){
        return ResponseEntity.ok(iProductoUseCase.save(productoRequestDto));
    }

    @PutMapping
    public ResponseEntity<ProductoResponseDto> update(@RequestBody ProductoRequestDto productoRequestDto){
        return ResponseEntity.of(iProductoUseCase.update(productoRequestDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(iProductoUseCase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
