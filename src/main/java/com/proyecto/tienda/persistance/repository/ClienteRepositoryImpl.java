package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.dto.cliente.ClienteDto;
import com.proyecto.tienda.domain.repository.IClienteRepository;
import com.proyecto.tienda.persistance.mapper.IClienteMapper;
import com.proyecto.tienda.persistance.crud.IClienteCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public List<ClienteDto> getAll() {
        return iClienteMapper.toClientesDto(iClienteCrudRepository.findAll());
    }

    @Override
    public Optional<ClienteDto> getById(Long id) {
        return iClienteCrudRepository.findById(id)
                .map(iClienteMapper::toClienteDto);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ClienteDto> getByEmail(String email) {
        return iClienteCrudRepository.findByEmail(email)
                .map(iClienteMapper::toClienteDto);
    }

    /**
     * Devuelve un cliente dado su username
     *
     * @param username@return devuelve el opcinal del cliente
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<ClienteDto> getByUsername(String username) {
        return iClienteCrudRepository.findByUsername(username)
                .map(iClienteMapper::toClienteDto);
    }
    @Transactional
    @Override
    public ClienteDto save(ClienteDto newCliente) {
        return iClienteMapper.toClienteDto(iClienteCrudRepository.save(iClienteMapper.toClienteEntity(newCliente)));
    }
    @Transactional
    @Override
    public void delete(Long id) {
        iClienteCrudRepository.deleteById(id);
    }
}
