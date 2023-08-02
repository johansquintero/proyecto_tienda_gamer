package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.ProductoPojo;
import com.proyecto.tienda.domain.repository.IProductoRepository;
import com.proyecto.tienda.domain.usecase.IProductoUseCase;
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
            return Optional.empty();
        }
        return Optional.of(iProductoRepository.save(producto));
    }

    @Override
    public boolean delete(Long id) {
        if (iProductoRepository.getProducto(id).isEmpty()){
            return false;
        }
        iProductoRepository.delete(id);
        return  true;
    }
}
