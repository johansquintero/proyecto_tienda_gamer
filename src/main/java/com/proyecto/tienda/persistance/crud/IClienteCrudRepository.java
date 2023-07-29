package com.proyecto.tienda.persistance.crud;

import com.proyecto.tienda.persistance.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que hereda la clase JPA
 */
public interface IClienteCrudRepository extends JpaRepository<ClienteEntity,Long> {
    Optional<ClienteEntity> findByEmail(String email);
    Optional<ClienteEntity> findByUsername(String username);
}
