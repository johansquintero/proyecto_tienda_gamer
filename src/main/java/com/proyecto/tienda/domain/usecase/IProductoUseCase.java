package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.pojo.producto.ProductoPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductoUseCase {
    List<ProductoPojo> getAll();

    Page<ProductoPojo> getPage(Pageable pageable);

    Optional<ProductoPojo> getProducto(Long id);

    List<ProductoPojo> getProductosByName(String title);

    List<ProductoPojo> getProductoByType(Long typeId);

    List<ProductoPojo> getProductoByPrice(Double price);

    ProductoPojo save(ProductoPojo newProducto);

    Optional<ProductoPojo> update(ProductoPojo producto);

    boolean delete(Long id);
}
