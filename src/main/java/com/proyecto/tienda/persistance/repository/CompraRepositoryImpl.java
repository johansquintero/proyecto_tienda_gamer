package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.dto.compra.CompraIdResponseDto;
import com.proyecto.tienda.domain.dto.compra.CompraRequestDto;
import com.proyecto.tienda.domain.dto.compra.CompraResponseDto;
import com.proyecto.tienda.domain.repository.ICompraRepository;
import com.proyecto.tienda.persistance.crud.ICompraCrudRepository;
import com.proyecto.tienda.persistance.crud.IProductoCrudRepository;
import com.proyecto.tienda.persistance.entity.CompraEntity;
import com.proyecto.tienda.persistance.entity.ProductoEntity;
import com.proyecto.tienda.persistance.mapper.compra.ICompraRequestMapper;
import com.proyecto.tienda.persistance.mapper.compra.ICompraResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompraRepositoryImpl implements ICompraRepository {
    private final ICompraCrudRepository iCompraCrudRepository;
    private final ICompraRequestMapper iCompraRequestMapper;
    private final ICompraResponseMapper iCompraResponseMapper;
    private final IProductoCrudRepository iProductoCrudRepository;

    @Override
    public List<CompraResponseDto> getAll() {
        return iCompraResponseMapper.toComprasResponseDto(iCompraCrudRepository.findAll());
    }

    @Override
    public List<CompraResponseDto> getAllByCustomer(Long customerId) {
        return iCompraResponseMapper.toComprasResponseDto(iCompraCrudRepository.findAllByCustomerId(customerId));
    }

    /**
     * @param customerId
     * @param pageable
     * @return
     */
    @Override
    public Page<CompraResponseDto> getAllByCustomerAndPage(Long customerId, Pageable pageable) {
        return this.iCompraCrudRepository.findAllByCustomerId(customerId,pageable).map(compraEntity -> {
            return this.iCompraResponseMapper.toCompraResponseDto(compraEntity);
        });
    }

    @Override
    public Optional<CompraResponseDto> getCompra(Long id) {
        return iCompraCrudRepository.findById(id).map(iCompraResponseMapper::toCompraResponseDto);
    }

    @Override
    public CompraIdResponseDto save(CompraRequestDto compraRequestDto) {
        CompraEntity compraEntity = iCompraRequestMapper.toCompraEntity(compraRequestDto);

        compraEntity.getCompraProductos().forEach(compraProductoEntity -> compraProductoEntity.setCompraEntity(compraEntity));

        CompraEntity compraSave = iCompraCrudRepository.save(compraEntity);

        //logica para restar la cantidad comprada
        compraRequestDto.getCompraProductos().forEach(compraProductoRequest -> {
            //obtienemos el producto actual
            ProductoEntity productoActual = iProductoCrudRepository.findById(compraProductoRequest.getProductId()).get();
            //le resta la cantidad a comprar al producto actual
            productoActual.setQuantity(productoActual.getQuantity() - compraProductoRequest.getQuantity());
            //se actualiza
            iProductoCrudRepository.save(productoActual);
        });

        return new CompraIdResponseDto(compraSave.getId());
    }

}
