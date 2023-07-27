package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.pojo.MarcaPojo;
import com.proyecto.tienda.domain.service.IMarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de las marcas
 */
@RestController
@RequestMapping(path = "/api/marcas")
@RequiredArgsConstructor
public class MarcaController {
    /**
     * Servicio de marca
     */
    private final IMarcaService iMarcaService;

    /**
     * Endpoint para retornar el cuerpo de la lista de todas las marcas
     */
    @GetMapping
    public ResponseEntity<List<MarcaPojo>> getAll(){
        return ResponseEntity.ok(iMarcaService.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(iMarcaService.getAll());
        //return new ResponseEntity<>(iMarcaService.getAll(),HttpStatus.OK);
    }

    /**
     * Endpoint para retornar una marca daado su id
     * @param id id de la marca a buscar
     * @return Cuerpo que contendra la marca encontrada, se usa el operador of para evaluar en el opcional si se encontro la marca
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaPojo> getMarca(@PathVariable(name = "id") Long id){
         return ResponseEntity.of(iMarcaService.getMarca(id));
    }

    @PostMapping
    public ResponseEntity<MarcaPojo> save(@RequestBody MarcaPojo marca){
        try {
            return new ResponseEntity<>(iMarcaService.save(marca), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    /*
    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable(name="id") Long id){
        return ResponseEntity.
    }*/
}
