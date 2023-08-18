package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.pojo.compra.CompraIdResponsePojo;
import com.proyecto.tienda.domain.pojo.compra.CompraRequestPojo;
import com.proyecto.tienda.domain.pojo.compra.CompraResponsePojo;
import com.proyecto.tienda.domain.repository.ICompraRepository;
import com.proyecto.tienda.persistance.crud.ICompraCrudRepository;
import com.proyecto.tienda.persistance.entity.CompraEntity;
import com.proyecto.tienda.persistance.mapper.compra.ICompraRequestMapper;
import com.proyecto.tienda.persistance.mapper.compra.ICompraResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompraRepositoryImpl implements ICompraRepository {
    private final ICompraCrudRepository iCompraCrudRepository;
    private final ICompraRequestMapper iCompraRequestMapper;
    private final ICompraResponseMapper iCompraResponseMapper;

    @Override
    public List<CompraResponsePojo> getAll() {
        return iCompraResponseMapper.toComprasResponsePojo(iCompraCrudRepository.findAll());
    }

    @Override
    public List<CompraResponsePojo> getAllByCustomer(Long customerId) {
        return iCompraResponseMapper.toComprasResponsePojo(iCompraCrudRepository.findAllByCustomerId(customerId));
    }

    @Override
    public Optional<CompraResponsePojo> getCompra(Long id) {
        return iCompraCrudRepository.findById(id).map(iCompraResponseMapper::toCompraResponsePojo);
    }

    @Override
    public CompraIdResponsePojo save(CompraRequestPojo compraRequestPojo) {
        CompraEntity compraEntity = iCompraRequestMapper.toCompraEntity(compraRequestPojo);
        compraEntity.getCompraProductos().forEach(compraProductoEntity -> compraProductoEntity.setCompraEntity(compraEntity));
        CompraEntity compraSave = iCompraCrudRepository.save(compraEntity);
        return new CompraIdResponsePojo(compraSave.getId());
    }

}
