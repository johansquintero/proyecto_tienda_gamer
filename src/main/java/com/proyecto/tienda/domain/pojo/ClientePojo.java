package com.proyecto.tienda.domain.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ClientePojo {
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

    @Override
    public String toString() {
        return "ClientePojo{" +
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
