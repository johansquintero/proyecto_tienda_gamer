package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.CompraIdResponsePojo;
import com.proyecto.tienda.domain.pojo.CompraRequestPojo;
import com.proyecto.tienda.domain.pojo.CompraResponsePojo;
import com.proyecto.tienda.domain.pojo.ProductoPojo;
import com.proyecto.tienda.domain.repository.ICompraRepository;
import com.proyecto.tienda.domain.repository.IProductoRepository;
import com.proyecto.tienda.domain.usecase.ICompraUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements ICompraUseCase {
    private final ICompraRepository iCompraRepository;
    private  final IProductoRepository iProductoRepository;

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
        return iCompraRepository.getCompra(id);
    }

    @Override
    public CompraIdResponsePojo save(CompraRequestPojo compraRequestPojo) {
        CompraIdResponsePojo responsePojo = iCompraRepository.save(compraRequestPojo);
        compraRequestPojo.getCompraProductos().forEach(compraProductoRequest ->{
                //obtienemos el producto actual
                ProductoPojo productoActual = iProductoRepository.getProducto(compraProductoRequest.getProductId()).get();
                //le resta la cantidad a comprar al producto actual
                productoActual.setQuantity(productoActual.getQuantity()-compraProductoRequest.getQuantity());
                //se actualiza
                iProductoRepository.save(productoActual);
        });
        return responsePojo;
    }
}
