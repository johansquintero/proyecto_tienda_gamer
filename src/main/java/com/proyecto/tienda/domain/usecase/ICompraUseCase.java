package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.pojo.compra.CompraIdResponsePojo;
import com.proyecto.tienda.domain.pojo.compra.CompraRequestPojo;
import com.proyecto.tienda.domain.pojo.compra.CompraResponsePojo;

import java.util.List;
import java.util.Optional;

public interface ICompraUseCase {
    List<CompraResponsePojo> getAll();

    List<CompraResponsePojo> getAllByCustomer(Long customerId);

    Optional<CompraResponsePojo> getCompra(Long id);

    CompraIdResponsePojo save(CompraRequestPojo compraRequestPojo);
}
