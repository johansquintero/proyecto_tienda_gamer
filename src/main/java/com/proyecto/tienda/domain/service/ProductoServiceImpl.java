package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.dto.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.dto.producto.ProductoResponseDto;
import com.proyecto.tienda.domain.repository.IProductoRepository;
import com.proyecto.tienda.domain.usecase.IProductoUseCase;
import com.proyecto.tienda.exception.ErrorAlertMessages;
import com.proyecto.tienda.exception.ErrorValidationExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements IProductoUseCase {
    private final IProductoRepository iProductoRepository;

    @Override
    public List<ProductoResponseDto> getAll() {
        return iProductoRepository.getAll();
    }

    @Override
    public Page<ProductoResponseDto> getPage(Pageable pageable) {
        return iProductoRepository.getPage(pageable);
    }

    @Override
    public Optional<ProductoResponseDto> getProducto(Long id) {
        Optional<ProductoResponseDto> productoOptional = iProductoRepository.getProducto(id);
        if (productoOptional.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.PRODUCT_NOT_EXISTS_MESSAGE);
        }
        return productoOptional;
    }

    @Override
    public Optional<ProductoResponseDto> getProductoByName(String name) {
        Optional<ProductoResponseDto> productoOptional = iProductoRepository.getProductoByName(name);
        if (productoOptional.isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.PRODUCT_NOT_EXISTS_MESSAGE);
        }
        return productoOptional;
    }

    @Override
    public List<ProductoResponseDto> getProductoByTipo(Long typeId) {
        return iProductoRepository.getProductoByTipo(typeId);
    }

    @Override
    public List<ProductoResponseDto> getProductoByPrice(Double price) {
        return iProductoRepository.getProductoByPrice(price);
    }

    @Override
    public ProductoResponseDto save(ProductoRequestDto newProducto) {
        return iProductoRepository.save(newProducto);
    }

    @Override
    public Optional<ProductoResponseDto> update(ProductoRequestDto producto) {
        if (iProductoRepository.getProducto(producto.getId()).isEmpty()) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.PRODUCT_NOT_EXISTS_MESSAGE);
        }
        return Optional.of(iProductoRepository.save(producto));
    }

    @Override
    public boolean delete(Long id) {
        ProductoResponseDto p = iProductoRepository.getProducto(id).get();
        if (p!=null) {
            throw new ErrorValidationExceptions(ErrorAlertMessages.PRODUCT_NOT_EXISTS_MESSAGE);
        }
        iProductoRepository.delete(id,p.getImagePath());
        return true;
    }

    /**
     * @param file
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> uploadFile(MultipartFile file, Long id) {
        return this.iProductoRepository.saveUploadFile(file,id);
    }
}
