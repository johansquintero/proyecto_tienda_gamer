package com.proyecto.tienda.domain.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoPojo {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Long typeId;
    private Integer amount;
    private String imagePath;

}
