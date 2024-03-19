package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.dto.compra.CompraIdResponseDto;
import com.proyecto.tienda.domain.dto.compra.CompraRequestDto;
import com.proyecto.tienda.domain.dto.compra.CompraResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICompraUseCase {
    List<CompraResponseDto> getAll();

    List<CompraResponseDto> getAllByCustomer(Long customerId);

    Optional<CompraResponseDto> getCompra(Long id);

    CompraIdResponseDto save(CompraRequestDto compraRequestDto);

    Page<CompraResponseDto> getAllByCustomerAndPage(Long customerId, Pageable pageable);
}
