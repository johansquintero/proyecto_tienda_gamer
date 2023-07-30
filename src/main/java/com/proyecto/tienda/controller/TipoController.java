package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.pojo.TipoPojo;
import com.proyecto.tienda.domain.usecase.ITipoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de los tipos
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/tipos")
public class TipoController {
    private final ITipoUseCase iTipoUseCase;

    @GetMapping
    ResponseEntity<List<TipoPojo>> getAll() {
        return ResponseEntity.ok(iTipoUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<TipoPojo> getTipo(@PathVariable Long id) {
        return ResponseEntity.of(iTipoUseCase.getTipo(id));
    }

    @PostMapping
    ResponseEntity<TipoPojo> save(@RequestBody TipoPojo newTipo) {
        return ResponseEntity.ok(iTipoUseCase.save(newTipo));
    }

    @PutMapping
    ResponseEntity<TipoPojo> update(@RequestBody TipoPojo tipo) {
        return ResponseEntity.of(iTipoUseCase.update(tipo));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(iTipoUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
