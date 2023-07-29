package com.proyecto.tienda.persistance.crud;

import com.proyecto.tienda.persistance.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que hereda la clase JPA
 */
public interface IMarcaCrudRepository extends JpaRepository<MarcaEntity,Long> {

}
