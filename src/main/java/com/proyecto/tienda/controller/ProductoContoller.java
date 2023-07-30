package com.proyecto.tienda.controller;


import com.proyecto.tienda.domain.pojo.ProductoPojo;
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
    public ResponseEntity<List<ProductoPojo>> getAll(){
        return ResponseEntity.ok(iProductoUseCase.getAll());
    }

    @GetMapping(path = "/page/{page}")
    public Page<ProductoPojo> page(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 2);
        return iProductoUseCase.getPage(pageable);
    }

    @GetMapping(path = "/price/{price}")
    public ResponseEntity<List<ProductoPojo>> getByPrice(@PathVariable Double price){
        return ResponseEntity.ok(iProductoUseCase.getProductoByPrice(price));
    }

    @GetMapping(path = "/title/{title}")
    public ResponseEntity<List<ProductoPojo>> getByTitle(@PathVariable String title){
        return ResponseEntity.ok(iProductoUseCase.getProductosByTitle(title));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoPojo> getProducto(@PathVariable Long id){
        return ResponseEntity.of(iProductoUseCase.getProducto(id));
    }
    @PostMapping
    public ResponseEntity<ProductoPojo> save(@RequestBody ProductoPojo productoPojo){
        return ResponseEntity.ok(iProductoUseCase.save(productoPojo));
    }

    @PutMapping
    public ResponseEntity<ProductoPojo> update(@RequestBody ProductoPojo productoPojo){
        return ResponseEntity.of(iProductoUseCase.update(productoPojo));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(iProductoUseCase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
