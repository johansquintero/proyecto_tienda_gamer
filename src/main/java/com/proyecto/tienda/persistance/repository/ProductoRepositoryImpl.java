package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.pojo.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.pojo.producto.ProductoResponseDto;
import com.proyecto.tienda.domain.repository.IProductoRepository;
import com.proyecto.tienda.persistance.crud.IProductoCrudRepository;
import com.proyecto.tienda.persistance.mapper.producto.IProductoRequestMapper;
import com.proyecto.tienda.persistance.mapper.producto.IProductoResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductoRepositoryImpl implements IProductoRepository {

    private final IProductoCrudRepository iProductoCrudRepository;
    private final IProductoRequestMapper iProductoRequestMapper;
    private final IProductoResponseMapper iProductoResponseMapper;

    /**
     * Obtiene el listado de todos los productos
     *
     * @return lista de productos
     */
    @Override
    public List<ProductoResponseDto> getAll() {
        return iProductoResponseMapper.toProductosResponseDto(iProductoCrudRepository.findAll());
    }

    /**
     * @param pageable pageable a buscar
     * @return pagina del producto
     */
    @Override
    public Page<ProductoResponseDto> getPage(Pageable pageable) {
        return iProductoCrudRepository.findAll(pageable).map(iProductoResponseMapper::toProductoResponseDto);
    }

    /**
     * obtiene un producto a partir de su id
     *
     * @param id id a consultar
     * @return optional del producto
     */
    @Override
    public Optional<ProductoResponseDto> getProducto(Long id) {
        return iProductoCrudRepository.findById(id).map(iProductoResponseMapper::toProductoResponseDto);
    }

    /**
     * obtiene un producto a partir de su titulo
     *
     * @param name titulo a buscar
     * @return Optional del producto
     */
    @Override
    public List<ProductoResponseDto> getProductosByName(String name) {
        return iProductoResponseMapper.toProductosResponseDto(iProductoCrudRepository.findAllByName(name));
    }

    /**
     * obtiene productos por tipo
     *
     * @param typeId id del tipo
     * @return Lista de los tipos encontrados
     */
    @Override
    public List<ProductoResponseDto> getProductoByTipo(Long typeId) {
        return iProductoResponseMapper.toProductosResponseDto(iProductoCrudRepository.findAllByTipoId(typeId));
    }

    /**
     * Obtiene los productos menores e iguales a un precio
     *
     * @param price precio comparar
     * @return lista de los productos
     */
    @Override
    public List<ProductoResponseDto> getProductoByPrice(Double price) {
        return iProductoResponseMapper.toProductosResponseDto(iProductoCrudRepository.findAllByPriceLessThanEqual(price));
    }

    /**
     * guarda un nuevo producto
     *
     * @param newProducto producto a guardar
     * @return producto guardado
     */
    @Override
    public ProductoResponseDto save(ProductoRequestDto newProducto) {
        return iProductoResponseMapper.toProductoResponseDto(iProductoCrudRepository.save(iProductoRequestMapper.toProductoEntity(newProducto)));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        iProductoCrudRepository.deleteById(id);
    }
}
