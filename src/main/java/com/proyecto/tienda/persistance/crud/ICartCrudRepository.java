package com.proyecto.tienda.persistance.crud;


import com.proyecto.tienda.persistance.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICartCrudRepository extends JpaRepository<CartEntity,Long> {
    Optional<CartEntity> findByCustomerId(Long id);
}
