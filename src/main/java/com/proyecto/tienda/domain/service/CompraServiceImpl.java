package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.compra.CompraIdResponseDto;
import com.proyecto.tienda.domain.dto.compra.CompraRequestDto;
import com.proyecto.tienda.domain.dto.compra.CompraResponseDto;
import com.proyecto.tienda.domain.repository.ICompraRepository;
import com.proyecto.tienda.domain.usecase.ICompraUseCase;
import com.proyecto.tienda.exception.ErrorAlertMessages;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements ICompraUseCase {
    private final ICompraRepository iCompraRepository;


    @Override
    public List<CompraResponseDto> getAll() {
        return iCompraRepository.getAll();
    }

    @Override
    public List<CompraResponseDto> getAllByCustomer(Long customerId) {
        return iCompraRepository.getAllByCustomer(customerId);
    }

    /**
     * @param customerId
     * @param pageable
     * @return
     */
    @Override
    public Page<CompraResponseDto> getAllByCustomerAndPage(Long customerId, Pageable pageable) {
        return this.iCompraRepository.getAllByCustomerAndPage(customerId, pageable);
    }

    @Override
    public Optional<CompraResponseDto> getCompra(Long id) {
        Optional<CompraResponseDto> compraResponseOptional = iCompraRepository.getCompra(id);
        if (compraResponseOptional.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.PURCHASE_NOT_EXISTS_MESSAGE);
        }
        return compraResponseOptional;
    }

    @Override
    public CompraIdResponseDto save(CompraRequestDto compraRequestDto) {
        CompraIdResponseDto responseDto = iCompraRepository.save(compraRequestDto);
        return responseDto;
    }
}
