package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.dto.compra.CompraIdResponseDto;
import com.proyecto.tienda.domain.dto.compra.CompraRequestDto;
import com.proyecto.tienda.domain.dto.compra.CompraResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de la compra
 */
public interface ICompraRepository {
    List<CompraResponseDto> getAll();

    List<CompraResponseDto> getAllByCustomer(Long customerId);

    Page<CompraResponseDto> getAllByCustomerAndPage(Long customerId, Pageable pageable);
    Optional<CompraResponseDto> getCompra(Long id);

    CompraIdResponseDto save(CompraRequestDto compraRequestDto);
}
