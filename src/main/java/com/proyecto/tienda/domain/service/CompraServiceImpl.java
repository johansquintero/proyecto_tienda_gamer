package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.pojo.compra.CompraIdResponsePojo;
import com.proyecto.tienda.domain.pojo.compra.CompraRequestPojo;
import com.proyecto.tienda.domain.pojo.compra.CompraResponsePojo;
import com.proyecto.tienda.domain.pojo.producto.ProductoResponseDto;
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
    public List<CompraResponsePojo> getAll() {
        return iCompraRepository.getAll();
    }

    @Override
    public List<CompraResponsePojo> getAllByCustomer(Long customerId) {
        return iCompraRepository.getAllByCustomer(customerId);
    }

    @Override
    public Optional<CompraResponsePojo> getCompra(Long id) {
        Optional<CompraResponsePojo> compraResponseOptional = iCompraRepository.getCompra(id);
        if (compraResponseOptional.isEmpty()){
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        return compraResponseOptional;
    }

    @Override
    public CompraIdResponsePojo save(CompraRequestPojo compraRequestPojo) {
        CompraIdResponsePojo responsePojo = iCompraRepository.save(compraRequestPojo);
        return responsePojo;
    }
}
