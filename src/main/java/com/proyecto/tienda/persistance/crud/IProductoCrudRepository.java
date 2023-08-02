package com.proyecto.tienda.persistance.crud;


import com.proyecto.tienda.persistance.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoCrudRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findAllByName(String name);

    List<ProductoEntity> findAllByPriceLessThanEqual(Double price);

    List<ProductoEntity> findAllByTypeId(Long typeId);

}
