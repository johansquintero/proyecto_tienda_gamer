package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.pojo.ClientePojo;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    /**
     * @return retorna una lista con todos los clientes
     */
    List<ClientePojo> getAll();

    /**
     * Devuelve un cliente dado su ID
     * @param id identificador del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClientePojo> getById(Long id);

    /**
     * Devuelve un cliente dado su email
     * @param email email del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClientePojo> getByEmail(String email);

    /**
     * Devuelve un cliente dado su username
     * @param username email del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClientePojo> getByUsername(String username);

    /**
     *Guarda un nuevo cliente
     * @param newCliente Cliente a insertar en la base de datos
     * @return retorna el cliente creada
     */
    ClientePojo save(ClientePojo newCliente);

    /**
     *Elimina un cliente de la base de datos
     * @param id identifiacor del cliente a eliminar
     */
    void delete(Long id);
}
