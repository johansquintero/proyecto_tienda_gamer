package com.proyecto.tienda.persistance.crud;


import com.proyecto.tienda.persistance.entity.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductoCrudRepository extends JpaRepository<ProductoEntity, Long> {
    Optional<ProductoEntity> findByName(String name);

    @Query("""
            SELECT p FROM ProductoEntity p
            WHERE p.name LIKE %:name%
            ORDER BY p.name ASC""")
    List<ProductoEntity> findAllByName(String name);

    @Query("""
            SELECT p FROM ProductoEntity p
            WHERE p.name LIKE %:name%""")
    Page<ProductoEntity> findAllByNameAndPage(String name, Pageable pageable);

    List<ProductoEntity> findAllByPriceLessThanEqual(Double price);

    List<ProductoEntity> findAllByTipoId(Long typeId);

}
