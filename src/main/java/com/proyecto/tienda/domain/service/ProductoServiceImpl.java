package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.producto.ProductoPojo;
import com.proyecto.tienda.domain.repository.IProductoRepository;
import com.proyecto.tienda.domain.usecase.IProductoUseCase;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements IProductoUseCase {

    private final IProductoRepository iProductoRepository;

    final String MESAGGE_EXISTS = "El producto ya se encuentra registrado en la base de datos";
    final String MESAGGE_NOT_EXISTS = "El producto no se encuentra registrado en la base de datos";


    @Override
    public List<ProductoPojo> getAll() {
        return iProductoRepository.getAll();
    }

    @Override
    public Page<ProductoPojo> getPage(Pageable pageable) {
        return iProductoRepository.getPage(pageable);
    }

    @Override
    public Optional<ProductoPojo> getProducto(Long id) {
        Optional<ProductoPojo> productoOptional = iProductoRepository.getProducto(id);
        if (productoOptional.isEmpty()){
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        return iProductoRepository.getProducto(id);
    }

    @Override
    public List<ProductoPojo> getProductosByName(String title) {
        return iProductoRepository.getProductosByName(title);
    }

    @Override
    public List<ProductoPojo> getProductoByType(Long typeId) {
        return iProductoRepository.getProductoByType(typeId);
    }

    @Override
    public List<ProductoPojo> getProductoByPrice(Double price) {
        return iProductoRepository.getProductoByPrice(price);
    }

    @Override
    public ProductoPojo save(ProductoPojo newProducto) {
        return iProductoRepository.save(newProducto);
    }

    @Override
    public Optional<ProductoPojo> update(ProductoPojo producto) {
        if (iProductoRepository.getProducto(producto.getId()).isEmpty()){
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        return Optional.of(iProductoRepository.save(producto));
    }

    @Override
    public boolean delete(Long id) {
        if (iProductoRepository.getProducto(id).isEmpty()){
            throw new ErrorValidationExceptions(this.MESAGGE_NOT_EXISTS);
        }
        iProductoRepository.delete(id);
        return  true;
    }
}
