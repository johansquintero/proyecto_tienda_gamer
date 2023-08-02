package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.pojo.CompraIdResponsePojo;
import com.proyecto.tienda.domain.pojo.CompraRequestPojo;
import com.proyecto.tienda.domain.pojo.CompraResponsePojo;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de la compra
 */
public interface ICompraRepository {
    List<CompraResponsePojo> getAll();

    List<CompraResponsePojo> getAllByCustomer(Long customerId);

    Optional<CompraResponsePojo> getCompra(Long id);

    CompraIdResponsePojo save(CompraRequestPojo compraRequestPojo);
}
