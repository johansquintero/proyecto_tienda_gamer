package com.proyecto.tienda.persistance.mapper;

import com.proyecto.tienda.domain.pojo.ClientePojo;
import com.proyecto.tienda.persistance.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    /**
     * Convierte una entidad cliente a cliente pojo
     *
     * @param clienteEntity Entidad a convertir
     * @return Pojo mapeado
     */
    ClientePojo toClientePojo(ClienteEntity clienteEntity);

    /**
     * Convierte un pojo cliente a cliente entidad
     *
     * @param clientePojo pojo a convertir
     * @return Entidad convertida
     */
    @Mapping(target = "compras", ignore = true)
    ClienteEntity toClienteEntity(ClientePojo clientePojo);


    /**
     * Convierte una lista de clientes de entidades a Pojos
     *
     * @param clienteEntities Lista de entidades de clientes
     * @return Lista de pojos mapeada
     */
    List<ClientePojo> toClientesPojo(List<ClienteEntity> clienteEntities);
}
