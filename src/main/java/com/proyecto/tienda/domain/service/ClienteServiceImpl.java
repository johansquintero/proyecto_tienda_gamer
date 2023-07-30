package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.ClientePojo;
import com.proyecto.tienda.domain.pojo.ClienteResponsePojo;
import com.proyecto.tienda.domain.repository.IClienteRepository;
import com.proyecto.tienda.exception.ClienteValidationExceptions;
import com.proyecto.tienda.domain.usecase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
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

    /**
     * Mensajes de excepciones error
     */
    private final String MESAGGE_EXISTS = "El cliente ya se encuentra registrado en la base de datos";
    private final String MESAGGE_NOT_EXISTS = "El cliente no se encuentra registrado en la base de datos";
    private final String MESAGGE_EMAIL = "El email no tiene el formato requerido";

    //private final PasswordEncoder passwordEncoder;

    /**
     * @return retorna una lista con todos los clientes
     */
    @Transactional(readOnly = true)
    @Override
    public List<ClientePojo> getAll() {
        return iClienteRepository.getAll();
    }

    /**
     * Devuelve un cliente dado su ID
     *
     * @param id identificador del cliente
     * @return devuelve el opcinal del cliente
     */
    @Override
    public Optional<ClientePojo> getCliente(Long id) {
        return iClienteRepository.getById(id);
    }

    /**
     * Devuelve un cliente dado su email
     *
     * @param email email del cliente
     * @return devuelve el opcinal del cliente
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<ClientePojo> getByEmail(String email) {
        return iClienteRepository.getByEmail(email);
    }

    /**
     * Guarda un nuevo cliente
     *
     * @param newCliente Cliente a insertar en la base de datos
     * @return retorna el response con la contrasena automatica del cliente creado
     */
    @Transactional
    @Override
    public ClienteResponsePojo save(ClientePojo newCliente) {
        if (!newCliente.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new ClienteValidationExceptions(this.MESAGGE_EMAIL);
        }else if (iClienteRepository.getByEmail(newCliente.getEmail()).isPresent() || iClienteRepository.getByUsername(newCliente.getUsername()).isPresent()){
            throw new ClienteValidationExceptions(this.MESAGGE_EXISTS);
        }

        String passwordGenerated = generateRandomPassword(10);
        newCliente.setPassword(passwordGenerated);
        newCliente.setActive(1);
        iClienteRepository.save(newCliente);
        return new ClienteResponsePojo(passwordGenerated);
    }

    /**
     * Actualiza un cliente existente
     *
     * @param cliente Cliente a actualizar en la base de datos
     * @return retorna un opcional del cliente actualizado
     */
    @Transactional
    @Override
    public Optional<ClientePojo> update(ClientePojo cliente) {
        if (iClienteRepository.getById(cliente.getId()).isEmpty()) {
            throw new ClienteValidationExceptions(this.MESAGGE_NOT_EXISTS);
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
            return false;
        }
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
