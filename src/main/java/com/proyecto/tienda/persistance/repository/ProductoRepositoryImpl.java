package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.pojo.ProductoPojo;
import com.proyecto.tienda.domain.repository.IProductoRepository;
import com.proyecto.tienda.persistance.crud.IProductoCrudRepository;
import com.proyecto.tienda.persistance.mapper.IProductoMapper;
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
    private final IProductoMapper iProductoMapper;

    /**
     * Obtiene el listado de todos los productos
     *
     * @return lista de productos
     */
    @Override
    public List<ProductoPojo> getAll() {
        return iProductoMapper.toProductosPojos(iProductoCrudRepository.findAll());
    }

    /**
     * @param pageable pageable a buscar
     * @return pagina del producto
     */
    @Override
    public Page<ProductoPojo> getPage(Pageable pageable) {
        return iProductoCrudRepository.findAll(pageable).map(iProductoMapper::toProductoPojo);
    }

    /**
     * obtiene un producto a partir de su id
     *
     * @param id id a consultar
     * @return optional del producto
     */
    @Override
    public Optional<ProductoPojo> getProducto(Long id) {
        return iProductoCrudRepository.findById(id).map(iProductoMapper::toProductoPojo);
    }

    /**
     * obtiene un producto a partir de su titulo
     *
     * @param title titulo a buscar
     * @return Optional del producto
     */
    @Override
    public List<ProductoPojo> getProductosByTitle(String title) {
        return iProductoMapper.toProductosPojos(iProductoCrudRepository.findAllByTitle(title));
    }

    /**
     * obtiene productos por tipo
     *
     * @param typeId id del tipo
     * @return Lista de los tipos encontrados
     */
    @Override
    public List<ProductoPojo> getProductoByType(Long typeId) {
        return iProductoMapper.toProductosPojos(iProductoCrudRepository.findAllByTypeId(typeId));
    }

    /**
     * Obtiene los productos menores e iguales a un precio
     *
     * @param price precio comparar
     * @return lista de los productos
     */
    @Override
    public List<ProductoPojo> getProductoByPrice(Double price) {
        return iProductoMapper.toProductosPojos(iProductoCrudRepository.findAllByPriceLessThanEqual(price));
    }

    /**
     * guarda un nuevo producto
     *
     * @param newProducto producto a guardar
     * @return producto guardado
     */
    @Override
    public ProductoPojo save(ProductoPojo newProducto) {
        return iProductoMapper.toProductoPojo(iProductoCrudRepository.save(iProductoMapper.toProductoEntity(newProducto)));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        iProductoCrudRepository.deleteById(id);
    }
}
