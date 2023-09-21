package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.dto.cliente.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    /**
     * @return retorna una lista con todos los clientes
     */
    List<ClienteDto> getAll();

    /**
     * Devuelve un cliente dado su ID
     * @param id identificador del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClienteDto> getById(Long id);

    /**
     * Devuelve un cliente dado su email
     * @param email email del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClienteDto> getByEmail(String email);

    /**
     * Devuelve un cliente dado su username
     * @param username email del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClienteDto> getByUsername(String username);

    /**
     *Guarda un nuevo cliente
     * @param newCliente Cliente a insertar en la base de datos
     * @return retorna el cliente creada
     */
    ClienteDto save(ClienteDto newCliente);

    /**
     *Elimina un cliente de la base de datos
     * @param id identifiacor del cliente a eliminar
     */
    void delete(Long id);
}
