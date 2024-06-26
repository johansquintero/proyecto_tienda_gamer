package com.proyecto.tienda.domain.repository;

import com.proyecto.tienda.domain.dto.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.dto.producto.ProductoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductoRepository {
    List<ProductoResponseDto> getAll();

    Page<ProductoResponseDto> getPage(Pageable pageable);

    Optional<ProductoResponseDto> getProducto(Long id);

    Optional<ProductoResponseDto> getProductoByName(String name);

    List<ProductoResponseDto> getAllProductosByName(String name);

    Page<ProductoResponseDto> getAllProductosByNameAndPage(String name, Pageable pageable);

    List<ProductoResponseDto> getProductoByTipo(Long typeId);

    List<ProductoResponseDto> getProductoByPrice(Double price);

    ProductoResponseDto save(ProductoRequestDto newProducto);

    Map<String, Object> saveUploadFile(MultipartFile file, Long id);
    void delete(Long id, String imagePath);
}
