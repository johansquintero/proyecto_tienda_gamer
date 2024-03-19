package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.dto.tipo.TipoDto;
import com.proyecto.tienda.domain.usecase.ITipoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    ResponseEntity<List<TipoDto>> getAll() {
        return ResponseEntity.ok(iTipoUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<TipoDto> getTipo(@PathVariable Long id) {
        return ResponseEntity.of(iTipoUseCase.getTipo(id));
    }

    @GetMapping(path = "/page/{page}")
    ResponseEntity<Page<TipoDto>> getTipoByPage(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page,2);
        return ResponseEntity.ok(this.iTipoUseCase.getAllByPage(pageable));
    }

    @PostMapping
    ResponseEntity<TipoDto> save(@RequestBody TipoDto newTipo) {
        return ResponseEntity.ok(iTipoUseCase.save(newTipo));
    }

    @PutMapping
    ResponseEntity<TipoDto> update(@RequestBody TipoDto tipo) {
        return ResponseEntity.of(iTipoUseCase.update(tipo));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(iTipoUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
