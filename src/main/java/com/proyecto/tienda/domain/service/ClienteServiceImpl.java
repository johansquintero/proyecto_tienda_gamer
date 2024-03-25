package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.cart.CartRequestDto;
import com.proyecto.tienda.domain.dto.cliente.ClienteDto;
import com.proyecto.tienda.domain.dto.cliente.ClienteResponseDto;
import com.proyecto.tienda.domain.repository.IClienteRepository;
import com.proyecto.tienda.domain.usecase.ICartUseCase;
import com.proyecto.tienda.exception.ErrorAlertMessages;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import com.proyecto.tienda.domain.usecase.IClienteUseCase;
import com.proyecto.tienda.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;


/**
 * Servicio del cliente
 */
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteUseCase {
    /**
     * Repositorio del cliente
     */
    private final IClienteRepository iClienteRepository;

    private final ICartUseCase iCartUseCase;

    private final PasswordEncoder passwordEncoder;

    /**
     * @return retorna una lista con todos los clientes
     */
    @Transactional(readOnly = true)
    @Override
    public List<ClienteDto> getAll() {
        return iClienteRepository.getAll();
    }

    /**
     * Devuelve un cliente dado su ID
     *
     * @param id identificador del cliente
     * @return devuelve el opcinal del cliente
     */
    @Override
    public Optional<ClienteDto> getCliente(Long id) {
        Optional<ClienteDto> clienteOptional = iClienteRepository.getById(id);
        if (clienteOptional.isEmpty()){
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_NOT_EXISTS_MESSAGE);
        }
        return clienteOptional;
    }

    /**
     * Devuelve un cliente dado su email
     *
     * @param email email del cliente
     * @return devuelve el opcinal del cliente
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<ClienteDto> getByEmail(String email) {
        Optional<ClienteDto> clienteOptional = iClienteRepository.getByEmail(email);
        if (clienteOptional.isEmpty()){
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_NOT_EXISTS_MESSAGE);
        }
        return clienteOptional;
    }

    /**
     * Devuelve un cliente dado su username
     *
     * @param username username del cliente
     * @return devuelve el opcinal del cliente
     */
    @Override
    public Optional<ClienteDto> getByUsername(String username) {
        Optional<ClienteDto> clienteOptional = iClienteRepository.getByUsername(username);
        if (clienteOptional.isEmpty()){
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_NOT_EXISTS_MESSAGE);
        }
        return clienteOptional;
    }

    /**
     * Guarda un nuevo cliente
     *
     * @param newCliente Cliente a insertar en la base de datos
     * @return retorna el response con la contrasena automatica del cliente creado
     */
    @Transactional
    @Override
    public ClienteResponseDto save(ClienteDto newCliente) {
        if (!newCliente.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_BAD_FORMAT_EMAIL_MESSAGE);
        }else if (iClienteRepository.getByEmail(newCliente.getEmail()).isPresent() || iClienteRepository.getByUsername(newCliente.getUsername()).isPresent()){
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_ALREADY_EXISTS_MESSAGE);
        }
        String passwordGenerated = generateRandomPassword(10);
        newCliente.setPassword(passwordEncoder.encode(passwordGenerated));
        newCliente.setActive(1);
        newCliente.setRole(Roles.USER);
        var c = iClienteRepository.save(newCliente);

        //crear el carrito del usuario
        var cart = new CartRequestDto();
        cart.setCustomerId(c.getId());
        this.iCartUseCase.save(cart);

        return new ClienteResponseDto(passwordGenerated);
    }

    /**
     * Actualiza un cliente existente
     *
     * @param cliente Cliente a actualizar en la base de datos
     * @return retorna un opcional del cliente actualizado
     */
    @Transactional
    @Override
    public Optional<ClienteDto> update(ClienteDto cliente) {
        if (iClienteRepository.getById(cliente.getId()).isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_NOT_EXISTS_MESSAGE);
        }
        return Optional.of(iClienteRepository.save(cliente));
    }

    /**
     * Elimina un cliente de la base de datos
     *
     * @param id identifiacor del cliente a eliminar
     */
    @Transactional
    @Override
    public boolean delete(Long id) {
        if (iClienteRepository.getById(id).isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.USER_NOT_EXISTS_MESSAGE);
        }
        //se elimina el carrito del usuario
        this.iCartUseCase.delete(id);

        iClienteRepository.delete(id);
        return true;
    }

    /**
     * Método para generar una contraseña alfanumérica aleatoria de una longitud específica
     */

    private String generateRandomPassword(int len) {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
