package com.proyecto.tienda.domain.dto.producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long tipoId;
    private Long marcaId;
    private Integer quantity;
    private String imagePath;
}
