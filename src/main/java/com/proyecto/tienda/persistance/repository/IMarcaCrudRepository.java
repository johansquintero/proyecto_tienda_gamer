package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.persistance.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que hereda la clase JPA
 */
public interface IMarcaCrudRepository extends JpaRepository<MarcaEntity,Long> {

}
