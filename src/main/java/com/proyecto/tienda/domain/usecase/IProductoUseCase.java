package com.proyecto.tienda.domain.usecase;

import com.proyecto.tienda.domain.dto.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.dto.producto.ProductoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductoUseCase {
    List<ProductoResponseDto> getAll();

    Page<ProductoResponseDto> getPage(Pageable pageable);

    List<ProductoResponseDto> getAllByName(String name);

    Page<ProductoResponseDto> getAllByNameAndPage(String name, Pageable pageable);


    Optional<ProductoResponseDto> getProducto(Long id);

    Optional<ProductoResponseDto> getProductoByName(String name);


    List<ProductoResponseDto> getProductoByTipo(Long typeId);

    List<ProductoResponseDto> getProductoByPrice(Double price);

    ProductoResponseDto save(ProductoRequestDto newProducto);

    Optional<ProductoResponseDto> update(ProductoRequestDto producto);

    boolean delete(Long id);

    Map<String, Object> uploadFile(MultipartFile file, Long id);
}
