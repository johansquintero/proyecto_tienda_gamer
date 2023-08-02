package com.proyecto.tienda.persistance.crud;

import com.proyecto.tienda.persistance.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICompraCrudRepository extends JpaRepository<CompraEntity,Long> {
    List<CompraEntity> findAllByCustomerId(Long customerId);
}
