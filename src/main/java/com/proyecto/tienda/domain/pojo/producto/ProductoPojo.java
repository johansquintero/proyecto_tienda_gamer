package com.proyecto.tienda.domain.pojo.producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoPojo {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long typeId;
    private Integer quantity;
    private String imagePath;
}
