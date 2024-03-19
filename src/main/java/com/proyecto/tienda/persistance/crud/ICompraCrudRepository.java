package com.proyecto.tienda.persistance.crud;

import com.proyecto.tienda.persistance.entity.CompraEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICompraCrudRepository extends JpaRepository<CompraEntity,Long> {
    List<CompraEntity> findAllByCustomerId(Long customerId);
    Page<CompraEntity> findAllByCustomerId(Long customerId, Pageable pageable);
}
