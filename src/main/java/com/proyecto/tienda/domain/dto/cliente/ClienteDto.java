package com.proyecto.tienda.domain.dto.cliente;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ClienteDto {
    /**
     * Identificador del cliente
     */
    private Long id;

    /**
     * Nombre de usuario del cliente
     */
    private String username;

    /**
     * Contraseña del cliente
     */
    private String password;

    /**
     * Direccion de correo electronico del cliente
     */
    private String email;

    /**
     * Numero telefonico del cliente
     */
    private String telephone;

    /**
     * Direccion de vivienda del cliente
     */
    private String address;

    /**
     * Estado del cliente
     */
    private int active;

    /**
     * Rol del cliente
     */
    private String role;

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", address='" + address + '\'' +
                ", active=" + active +
                '}';
    }
}
