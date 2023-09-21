package com.proyecto.tienda.persistance.mapper;

import com.proyecto.tienda.domain.dto.cliente.ClienteDto;
import com.proyecto.tienda.persistance.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    /**
     * Convierte una entidad cliente a cliente dto
     *
     * @param clienteEntity Entidad a convertir
     * @return Pojo mapeado
     */
    ClienteDto toClienteDto(ClienteEntity clienteEntity);

    /**
     * Convierte un dto cliente a cliente entidad
     *
     * @param clienteDto dto a convertir
     * @return Entidad convertida
     */
    @Mapping(target = "compras", ignore = true)
    ClienteEntity toClienteEntity(ClienteDto clienteDto);


    /**
     * Convierte una lista de clientes de entidades a Pojos
     *
     * @param clienteEntities Lista de entidades de clientes
     * @return Lista de pojos mapeada
     */
    List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntities);
}
