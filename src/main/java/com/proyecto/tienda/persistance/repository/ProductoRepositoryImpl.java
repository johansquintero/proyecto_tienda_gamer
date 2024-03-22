package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.dto.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.dto.producto.ProductoResponseDto;
import com.proyecto.tienda.domain.repository.IProductoRepository;
import com.proyecto.tienda.domain.usecase.IUploadFileUseCase;
import com.proyecto.tienda.persistance.crud.IProductoCrudRepository;
import com.proyecto.tienda.persistance.entity.ProductoEntity;
import com.proyecto.tienda.persistance.mapper.producto.IProductoRequestMapper;
import com.proyecto.tienda.persistance.mapper.producto.IProductoResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductoRepositoryImpl implements IProductoRepository {

    private final IProductoCrudRepository iProductoCrudRepository;
    private final IProductoRequestMapper iProductoRequestMapper;
    private final IProductoResponseMapper iProductoResponseMapper;
    private final IUploadFileUseCase iUploadFileUseCase;

    /**
     * Obtiene el listado de todos los productos
     *
     * @return lista de productos
     */
    @Transactional(readOnly = true)
    @Override
    public List<ProductoResponseDto> getAll() {
        return iProductoResponseMapper.toProductosResponseDto(iProductoCrudRepository.findAll());
    }

    /**
     * @param pageable pageable a buscar
     * @return pagina del producto
     */
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    @Override
    public Optional<ProductoResponseDto> getProductoByName(String name) {
        return this.iProductoCrudRepository.findByName(name).map(this.iProductoResponseMapper::toProductoResponseDto);
    }

    /**
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ProductoResponseDto> getAllProductosByName(String name) {
        return this.iProductoResponseMapper.toProductosResponseDto(this.iProductoCrudRepository.findAllByName(name));
    }

    /**
     * @param name
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<ProductoResponseDto> getAllProductosByNameAndPage(String name, Pageable pageable) {
        return this.iProductoCrudRepository.findAllByNameAndPage(name,pageable).map(productoEntity -> {
            return this.iProductoResponseMapper.toProductoResponseDto(productoEntity);
        });
    }

    /**
     * obtiene productos por tipo
     *
     * @param typeId id del tipo
     * @return Lista de los tipos encontrados
     */
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
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
    @Transactional
    @Override
    public ProductoResponseDto save(ProductoRequestDto newProducto) {
        return iProductoResponseMapper.toProductoResponseDto(iProductoCrudRepository.save(iProductoRequestMapper.toProductoEntity(newProducto)));
    }

    /**
     * @param id
     */
    @Transactional
    @Override
    public void delete(Long id, String imagePath) {
        iUploadFileUseCase.delete(imagePath);
        iProductoCrudRepository.deleteById(id);
    }

    /**Metodo para actualizar y guardar el archivo de imagen del producto
     * @return
     */
    @Transactional
    @Override
    public Map<String, Object> saveUploadFile(MultipartFile file, Long id) {
        // se crea el map para enviar el response al front que contendra los
        // correspondientes mensajes y respuestas del servidor
        Map<String, Object> response = new HashMap<>();
        // Obtenemos el producto por el id que viene en el body del request
        ProductoEntity producto = iProductoCrudRepository.getReferenceById(id);

        if (!file.isEmpty() && producto != null) {// se valida el nombre del archivo y el producto existen
            String newName = null;
            try {
                // se copia el archvo en la ruta
                newName = iUploadFileUseCase.copy(file,producto.getId().toString());
            } catch (IOException e) {
                response.put("mensaje", "Error al subir la imagen:");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return response;
            }
            String prevImagePath = producto.getImagePath();
            iUploadFileUseCase.delete(prevImagePath);
            producto.setImagePath(newName);
            iProductoCrudRepository.save(producto);
            response.put("mensaje", "Has subido correctamente la imagen");
            response.put("newImage",newName);
            return response;
        }
        response.put("mensaje", "La imagen o el producto no existen");
        response.put("Error", "Ha ocurrido un error al realizar la solicitud");
        return response;
    }
}
