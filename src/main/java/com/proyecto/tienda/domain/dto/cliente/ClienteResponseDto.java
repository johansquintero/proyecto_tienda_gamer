package com.proyecto.tienda.domain.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * dto del Cliente que solo se usara de respuesta cuando se cree un nuevo cliente, solo transfiere la contraseña
 * ya que esta se genera automaticamente en la capa de negocio del servicio
 */
@Getter@Setter
@AllArgsConstructor
public class ClienteResponseDto {
    private String password;
}
