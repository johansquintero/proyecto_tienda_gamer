package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.pojo.cliente.ClientePojo;
import com.proyecto.tienda.domain.repository.IClienteRepository;
import com.proyecto.tienda.persistance.mapper.IClienteMapper;
import com.proyecto.tienda.persistance.crud.IClienteCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementacion del la interfaz del repositorio del cliente
 */
@Repository
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements IClienteRepository {
    /**
     * Crud del Cliente
     */
    private final IClienteCrudRepository iClienteCrudRepository;

    /**
     * Mapper de la marca
     */
    private final IClienteMapper iClienteMapper;

    @Override
    public List<ClientePojo> getAll() {
        return iClienteMapper.toClientesPojo(iClienteCrudRepository.findAll());
    }

    @Override
    public Optional<ClientePojo> getById(Long id) {
        return iClienteCrudRepository.findById(id)
                .map(iClienteMapper::toClientePojo);
    }

    @Override
    public Optional<ClientePojo> getByEmail(String email) {
        return iClienteCrudRepository.findByEmail(email)
                .map(iClienteMapper::toClientePojo);
    }

    /**
     * Devuelve un cliente dado su username
     *
     * @param username@return devuelve el opcinal del cliente
     */
    @Override
    public Optional<ClientePojo> getByUsername(String username) {
        return iClienteCrudRepository.findByUsername(username)
                .map(iClienteMapper::toClientePojo);
    }

    @Override
    public ClientePojo save(ClientePojo newCliente) {
        return iClienteMapper.toClientePojo(iClienteCrudRepository.save(iClienteMapper.toClienteEntity(newCliente)));
    }

    @Override
    public void delete(Long id) {
        iClienteCrudRepository.deleteById(id);
    }
}
