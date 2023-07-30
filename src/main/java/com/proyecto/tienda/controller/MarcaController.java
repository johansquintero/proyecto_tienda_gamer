package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.pojo.MarcaPojo;
import com.proyecto.tienda.domain.usecase.IMarcaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de las marcas
 */
@RestController
@RequestMapping(path = "/marcas")
@RequiredArgsConstructor
public class MarcaController {
    /**
     * Servicio de marca
     */
    private final IMarcaUseCase iMarcaUseCase;

    /**
     * Endpoint para retornar el cuerpo de la lista de todas las marcas
     */
    @GetMapping
    public ResponseEntity<List<MarcaPojo>> getAll(){
        return ResponseEntity.ok(this.iMarcaUseCase.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(this.iMarcaUseCase.getAll());
        //return new ResponseEntity<>(this.iMarcaUseCase.getAll(),HttpStatus.OK);
    }

    /**
     * Endpoint para retornar una marca dado su id
     * @param id id de la marca a buscar
     * @return Cuerpo que contendra la marca encontrada, se usa el operador of para evaluar en el opcional si se encontro la marca
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaPojo> getMarca(@PathVariable(name = "id") Long id){
         return ResponseEntity.of(this.iMarcaUseCase.getMarca(id));
    }

    /**
     * Endpoint para guardar una marca en la base de datos
     * @param marca cuerpo del objeto marca
     * @return marca creada en la base de datos
     */
    @PostMapping
    public ResponseEntity<MarcaPojo> save(@RequestBody MarcaPojo marca){
        return ResponseEntity.ok(iMarcaUseCase.save(marca));
    }

    /**
     * Endpoint para actualizar una marca en la base de datos
     * @param marca cuerpo del objeto marca
     * @return marca actualizada en la base de datos
     */
    @PatchMapping
    public ResponseEntity<MarcaPojo> update(@RequestBody MarcaPojo marca){
        return ResponseEntity.of(iMarcaUseCase.update(marca));
    }

    /**
     * Elimina una marca dado su id
     * @param id id de la marca a eliminar
     * @return retorna OK si la elimina y NOT_FOUND de lo contrario
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(this.iMarcaUseCase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
