package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.pojo.cliente.ClientePojo;
import com.proyecto.tienda.domain.pojo.cliente.ClienteResponsePojo;

import java.util.List;
import java.util.Optional;

public interface IClienteUseCase {
    /**
     * @return retorna una lista con todos los clientes
     */
    List<ClientePojo> getAll();

    /**
     * Devuelve un cliente dado su ID
     * @param id identificador del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClientePojo> getCliente(Long id);

    /**
     * Devuelve un cliente dado su email
     * @param email email del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClientePojo> getByEmail(String email);

    /**
     * Devuelve un cliente dado su username
     * @param username username del cliente
     * @return devuelve el opcinal del cliente
     */
    Optional<ClientePojo> getByUsername(String username);


    /**
     *Guarda un nuevo cliente
     * @param newCliente Cliente a insertar en la base de datos
     * @return retorna el opcional del response del cliente creado
     */
    ClienteResponsePojo save(ClientePojo newCliente);

    /**
     *Actualiza un cliente existente
     * @param cliente Cliente a actualizar en la base de datos
     * @return retorna un opcional del cliente actualizado
     */
    Optional<ClientePojo> update(ClientePojo cliente);


    /**
     *Elimina un cliente de la base de datos
     * @param id identifiacor del cliente a eliminar
     */
    boolean delete(Long id);
}
