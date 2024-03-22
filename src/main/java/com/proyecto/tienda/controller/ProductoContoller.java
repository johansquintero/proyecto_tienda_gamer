package com.proyecto.tienda.controller;


import com.proyecto.tienda.domain.dto.producto.ProductoRequestDto;
import com.proyecto.tienda.domain.dto.producto.ProductoResponseDto;
import com.proyecto.tienda.domain.usecase.IProductoUseCase;
import com.proyecto.tienda.domain.usecase.IUploadFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/productos")
public class ProductoContoller {
    private final IProductoUseCase iProductoUseCase;
    private final IUploadFileUseCase iUploadFileUseCase;

    @GetMapping
    public ResponseEntity<List<ProductoResponseDto>> getAll(){
        return ResponseEntity.ok(iProductoUseCase.getAll());
    }

    @GetMapping(path = "/page/{page}")
    public ResponseEntity<Page<ProductoResponseDto>> page(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 2);
        return ResponseEntity.ok(iProductoUseCase.getPage(pageable));
    }

    @GetMapping(path = "/price/{price}")
    public ResponseEntity<List<ProductoResponseDto>> getByPrice(@PathVariable Double price){
        return ResponseEntity.ok(iProductoUseCase.getProductoByPrice(price));
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<ProductoResponseDto> getByName(@PathVariable String name){
        return ResponseEntity.of(iProductoUseCase.getProductoByName(name));
    }

    @GetMapping(path = "/all/name/{name}")
    public ResponseEntity<List<ProductoResponseDto>> getAllByName(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(this.iProductoUseCase.getAllByName(name));
    }
    @GetMapping(path = "/page={page}/name={name}")
    public ResponseEntity<Page<ProductoResponseDto>> getAllByNamePage(
            @PathVariable(name = "page") Integer page,@PathVariable(name = "name") String name){
        Pageable pageable = PageRequest.of(page,2);
        return ResponseEntity.ok(this.iProductoUseCase.getAllByNameAndPage(name,pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoResponseDto> getProducto(@PathVariable Long id){
        return ResponseEntity.of(iProductoUseCase.getProducto(id));
    }
    @PostMapping
    public ResponseEntity<ProductoResponseDto> save(@RequestBody ProductoRequestDto productoRequestDto){
        return ResponseEntity.ok(iProductoUseCase.save(productoRequestDto));
    }

    @PutMapping
    public ResponseEntity<ProductoResponseDto> update(@RequestBody ProductoRequestDto productoRequestDto){
        return ResponseEntity.of(iProductoUseCase.update(productoRequestDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(iProductoUseCase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id){
        return new ResponseEntity<Map<String, Object>>(iProductoUseCase.uploadFile(file,id), HttpStatus.CREATED);
    }
    @GetMapping(path = "/uploads/img/{imageName:.+}")
    public ResponseEntity<Resource> loadImage(@PathVariable String imageName) throws IOException {
        Resource recurso=null;
        try {
            recurso = iUploadFileUseCase.load(imageName);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // se crea la cabecera de la respuesta con la instructiva attachment para forzar
        // la descarga
        String contentType = Files.probeContentType(recurso.getFile().toPath());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,contentType).body(recurso);
    }
}
