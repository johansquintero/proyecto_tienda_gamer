package com.proyecto.tienda.domain.dto.producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoResponseDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String tipo;
    private String marca;
    private Integer quantity;
    private String imagePath;
}
