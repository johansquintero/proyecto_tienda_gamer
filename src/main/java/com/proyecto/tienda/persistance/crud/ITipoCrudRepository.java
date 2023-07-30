package com.proyecto.tienda.persistance.crud;

import com.proyecto.tienda.persistance.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITipoCrudRepository extends JpaRepository<TipoEntity,Long> {
    Optional<TipoEntity> findByNombre(String nombre);
}
