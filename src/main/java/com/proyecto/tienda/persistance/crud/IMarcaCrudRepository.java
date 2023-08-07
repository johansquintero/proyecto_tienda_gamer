package com.proyecto.tienda.persistance.crud;

import com.proyecto.tienda.persistance.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que hereda la clase JPA
 */
public interface IMarcaCrudRepository extends JpaRepository<MarcaEntity,Long> {
    Optional<MarcaEntity> findByName(String name);
}
