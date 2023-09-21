package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.compra.CompraIdResponseDto;
import com.proyecto.tienda.domain.dto.compra.CompraRequestDto;
import com.proyecto.tienda.domain.dto.compra.CompraResponseDto;
import com.proyecto.tienda.domain.repository.ICompraRepository;
import com.proyecto.tienda.domain.usecase.ICompraUseCase;
import com.proyecto.tienda.domain.usecase.IProductoUseCase;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements ICompraUseCase {
    private final ICompraRepository iCompraRepository;
    private final IProductoUseCase iProductoUseCase;

    final String MESAGGE_EXISTS = "La compra ya se encuentra registrada en la base de datos";
    final String MESAGGE_NOT_EXISTS = "La compra no se encuentra registrada en la base de datos";

    @Override
    public List<CompraResponseDto> getAll() {
        return iCompraRepository.getAll();
    }

    @Override
    public List<CompraResponseDto> getAllByCustomer(Long customerId) {
        return iCompraRepository.getAllByCustomer(customerId);
    }

    @Override
    public Optional<CompraResponseDto> getCompra(Long id) {
        Optional<CompraResponseDto> compraResponseOptional = iCompraRepository.getCompra(id);
        if (compraResponseOptional.isEmpty()){
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        return compraResponseOptional;
    }

    @Override
    public CompraIdResponseDto save(CompraRequestDto compraRequestDto) {
        CompraIdResponseDto responseDto = iCompraRepository.save(compraRequestDto);
        return responseDto;
    }
}
