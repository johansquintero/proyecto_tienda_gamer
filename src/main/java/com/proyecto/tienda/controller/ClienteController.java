package com.proyecto.tienda.controller;

import com.proyecto.tienda.domain.pojo.ClientePojo;
import com.proyecto.tienda.domain.pojo.ClienteResponsePojo;
import com.proyecto.tienda.domain.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de los clientes
 */
@RequiredArgsConstructor
@RequestMapping(path = "/clientes")
@RestController
public class ClienteController {

    /**
     * Servicio de los clientes
     */
    private final IClienteService iClienteService;

    /**
     * @return retorna una lista con todos los clientes
     */
    @GetMapping
    public ResponseEntity<List<ClientePojo>> getAll() {
        return ResponseEntity.ok(iClienteService.getAll());
    }

    /**
     * Devuelve un cliente dado su ID
     *
     * @param id identificador del cliente
     * @return devuelve el opcinal del cliente
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientePojo> getCliente(@PathVariable(name = "id") Long id) {
        return ResponseEntity.of(iClienteService.getCliente(id));
    }

    /**
     * Devuelve un cliente dado su email
     *
     * @param email email del cliente
     * @return devuelve el opcinal del cliente
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ClientePojo> getClienteByEmail(@PathVariable(name = "email") String email) {
        return ResponseEntity.of(iClienteService.getByEmail(email));
    }

    /**
     * Guarda un nuevo cliente
     *
     * @param newCliente Cliente a insertar en la base de datos
     * @return retorna el opcional del response del cliente creado
     */
    @PostMapping
    public ResponseEntity<ClienteResponsePojo> save(@RequestBody ClientePojo newCliente) {
        return ResponseEntity.ok(iClienteService.save(newCliente));
    }

    /**
     * Actualiza un cliente existente
     *
     * @param cliente Cliente a actualizar en la base de datos
     * @return retorna un opcional del cliente actualizado
     */
    @PutMapping
    public ResponseEntity<ClientePojo> update(@RequestBody ClientePojo cliente) {
        return ResponseEntity.of(iClienteService.update(cliente));
    }

    /**
     * Elimina un cliente de la base de datos
     *
     * @param id identifiacor del cliente a eliminar
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(iClienteService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}