package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.pojo.producto.ProductoPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductoRepository {
    List<ProductoPojo> getAll();

    Page<ProductoPojo> getPage(Pageable pageable);

    Optional<ProductoPojo> getProducto(Long id);

    List<ProductoPojo> getProductosByName(String title);

    List<ProductoPojo> getProductoByType(Long typeId);

    List<ProductoPojo> getProductoByPrice(Double price);

    ProductoPojo save(ProductoPojo newProducto);

    void delete(Long id);
}
